package com.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mapper.*;
import com.pojo.*;
import com.service.OrderListService;
import com.util.ResponseDTO;
import com.vo.OrderVo;
import com.vo.PageVo;
import com.vo.SearchPageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author 李璟瑜
 * @date 2024/8/14 9:12
 * @description:
 */
@Service
public class OrderListServiceImpl implements OrderListService {
    @Autowired
    PhyOrderMapper mapper;

    @Autowired
    PhyPatientMapper patientMapper;

    @Autowired
    PhyProjectSubitemConnectMapper projectSubitemConnectMapper;

    @Autowired
    PhyComboProjectConnetMapper comboProjectConnetMapper;

    @Autowired
    PhyOrderContextMapper orderContextMapper;

    @Autowired
    PhyProjectMapper projectMapper;

    @Autowired
    PhySubitemConclutionMapper subitemConclutionMapper;

    @Autowired
    PhyConclutionMapper conclutionMapper;

    @Override
    public ResponseDTO getOrderListByIdInPage(PageVo vo) {
        PageHelper.startPage(vo.getPagen(),vo.getLimit());
        List<PhyOrder> orderListByIdInPage = mapper.getOrderListByIdInPage(vo.getId());
        PageInfo<PhyOrder> pageInfo = new PageInfo<>(orderListByIdInPage);
        return ResponseDTO.success(pageInfo);
    }

    @Override
    public ResponseDTO searchOrderByIdInPage(SearchPageVo vo) {
        PageHelper.startPage(vo.getPagen(), vo.getLimit());
        List<PhyOrder> phyOrders = mapper.searchOrderByIdInPage(Integer.valueOf(vo.getIden()), vo.getName());
        PageInfo<PhyOrder> pageInfo = new PageInfo<>(phyOrders);
        return ResponseDTO.success(pageInfo);
    }

    @Override
    @Transactional
    public ResponseDTO checkOutOrder(PhyOrder vo) {
        try {
            PhyPatient patient = patientMapper.selectByPrimaryKey(vo.getPatientId());
            int i = patient.getPatientBuddget().compareTo(vo.getOrderPrice());
            if (i < 0){
                return new ResponseDTO(-2,"余额不足",null);
            }else {
                //修改訂單狀態
                patientMapper.checkOutOrder(vo.getPatientId(), vo.getOrderPrice());
                vo.setOrderStatus("1");
                int i1 = mapper.updateByPrimaryKeySelective(vo);

                //创建细项内容
                List<PhyOrderContext> list = orderContextMapper.getContextListByOrderNumber(vo.getOrderNumber());
                for (PhyOrderContext context : list) {
                    //是套餐
                    if (context.getProjectId() == 0){
                        List<PhyProject> projects = comboProjectConnetMapper.getProjectByComboId(context.getComboId());
                        for (PhyProject project : projects) {
                            List<PhySubitem> subitems = projectSubitemConnectMapper.selectAllByProjectId(project.getProjectId());
                            for (PhySubitem subitem : subitems) {
                                PhySubitemConclution conclution = new PhySubitemConclution();
                                conclution.setOrderNameber(vo.getOrderNumber());
                                conclution.setSubitemId(subitem.getSubitemId());
                                conclution.setDepartmentId(project.getDepartmentId());
                                subitemConclutionMapper.insertSelective(conclution);
                            }
                        }
                    }else {
                        PhyProject phyProject = projectMapper.selectByPrimaryKey(context.getProjectId());
                        List<PhySubitem> subitems = projectSubitemConnectMapper.selectAllByProjectId(context.getProjectId());
                        for (PhySubitem subitem : subitems) {
                            PhySubitemConclution conclution = new PhySubitemConclution();
                            conclution.setOrderNameber(vo.getOrderNumber());
                            conclution.setSubitemId(subitem.getSubitemId());
                            conclution.setDepartmentId(phyProject.getDepartmentId());
                            subitemConclutionMapper.insertSelective(conclution);
                        }
                    }
                }
                PhyConclution allConclution = new PhyConclution();
                allConclution.setOrderNumber(vo.getOrderNumber());
                conclutionMapper.insertSelective(allConclution);

                return ResponseDTO.success(i1);
            }
        } catch (Exception e) {
            System.out.println("checkOutOrder回滚回滚");
            return ResponseDTO.fail();
        }
    }


    @Override
    public ResponseDTO addOrder(OrderVo vo) {
        PhyOrder order = new PhyOrder();
        order.setOrderNumber(vo.getOrderNumber());
        order.setPatientId(vo.getPatientId());
        order.setOrderPrice(vo.getPrice());
        mapper.insertSelective(order);

        List<PhyCombo> combos = vo.getCombos();
        for (PhyCombo combo : combos) {
            PhyOrderContext context = new PhyOrderContext();
            context.setOrderNumber(vo.getOrderNumber());
            context.setComboId(combo.getComboId());
            orderContextMapper.insertSelective(context);
        }

        List<PhyProject> projects = vo.getProjects();
        for (PhyProject project : projects) {
            PhyOrderContext context = new PhyOrderContext();
            context.setOrderNumber(vo.getOrderNumber());
            context.setProjectId(project.getProjectId());
            orderContextMapper.insertSelective(context);
        }


        return ResponseDTO.success();
    }
}
