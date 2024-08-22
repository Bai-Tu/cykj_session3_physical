package com.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mapper.PatPatientMapper;
import com.pojo.*;
import com.service.PatientService;
import com.util.JwtUtil;
import com.util.Md5;
import com.util.ResponseDTO;
import com.vo.LoginVo;
import com.vo.PageVo;
import com.vo.RegisterVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;

/**
 * @author 李璟瑜
 * @date 2024/8/16 14:55
 * @description:
 */
@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    PatPatientMapper mapper;


    @Override
    public ResponseDTO patientLogin(LoginVo vo) {
        String encrypted = Md5.getEncrypted(vo.getPwd());
        vo.setPwd(encrypted);
        List<PhyPatient> phyPatients = mapper.selectAllByPatientIdentityOrPatientPhoneAndPatientPassword(vo.getAcc(), vo.getAcc(), vo.getPwd());
        if (phyPatients.size()!=0){
            if (phyPatients.get(0).getPatientStatus() != 0){
                HashMap<String,Object> data = new HashMap<>();
                data.put("adminInfo",phyPatients.get(0));
                String token = JwtUtil.generateToken(data);
                return ResponseDTO.success(token);
            }else {
                return new ResponseDTO(-2,"冻结",null);
            }
        }else {
            return ResponseDTO.fail();
        }
    }

    @Override
    public ResponseDTO registerPatient(RegisterVo vo) {
        int result = 0;
        if (vo.getAcc().length() == 11){
            PhyPatient patient = mapper.searchPatientByPhone(vo.getAcc());
            if (patient == null){
                result = mapper.registerByPhone(vo);
                if (result >= 0){
                    PhyPatient newPatient = mapper.searchPatientByPhone(vo.getAcc());
                    HashMap<String,Object> data = new HashMap<>();
                    data.put("adminInfo",newPatient);
                    String token = JwtUtil.generateToken(data);

                    return ResponseDTO.success(token);
                }else {
                    return new ResponseDTO(-100,"注册失败",null);
                }
            }else {
                return new ResponseDTO(-1,"账号已存在",null);
            }
        }else {
            PhyPatient patient = mapper.searchPatientByIdentity(vo.getAcc());
            if (patient == null){
                result = mapper.registerByIdentity(vo);
                if (result >= 0){
                    PhyPatient newPatient = mapper.searchPatientByIdentity(vo.getAcc());
                    HashMap<String,Object> data = new HashMap<>();
                    data.put("adminInfo",newPatient);
                    String token = JwtUtil.generateToken(data);

                    return ResponseDTO.success(token);
                }else {
                    return new ResponseDTO(-100,"注册失败",null);
                }
            }else {
                return new ResponseDTO(-1,"账号已存在",null);
            }
        }
    }

    @Override
    public ResponseDTO updatePatient(PhyPatient patient) {
        int i = mapper.updateByPrimaryKeySelective(patient);
        if (i > 0){
            PhyPatient phyPatient = mapper.selectByPrimaryKey(patient.getPatientId());
            return ResponseDTO.success(phyPatient);
        }else {
            return ResponseDTO.fail();
        }
    }

    @Override
    public ResponseDTO getOrderListByIdInPage(PageVo vo) {
        PageHelper.startPage(vo.getPagen(),vo.getLimit());
        List<PhyOrder> orderListByIdInPage = mapper.getOrderListByIdInPage(vo.getId());
        PageInfo<PhyOrder> pageInfo = new PageInfo<>(orderListByIdInPage);
        return ResponseDTO.success(pageInfo);
    }

    @Override
    @Transactional
    public ResponseDTO checkOutOrder(PhyOrder vo) {
        try {
            PhyPatient patient = mapper.selectPatientByPrimaryKey(vo.getPatientId());
            int i = patient.getPatientBuddget().compareTo(vo.getOrderPrice());
            if (i < 0){
                return new ResponseDTO(-2,"余额不足",null);
            }else {
                //修改訂單狀態
                mapper.checkOutOrder(vo.getPatientId(), vo.getOrderPrice());
                vo.setOrderStatus("1");
                int i1 = mapper.updateOrderByPrimaryKeySelective(vo);

                //创建细项内容
                List<PhyOrderContext> list = mapper.getContextListByOrderNumber(vo.getOrderNumber());
                for (PhyOrderContext context : list) {
                    //是套餐
                    if (context.getProjectId() == 0){
                        List<PhyProject> projects = mapper.getProjectByComboId(context.getComboId());
                        for (PhyProject project : projects) {
                            List<PhySubitem> subitems = mapper.selectAllByProjectId(project.getProjectId());
                            for (PhySubitem subitem : subitems) {
                                PhySubitemConclution conclution = new PhySubitemConclution();
                                conclution.setOrderNameber(vo.getOrderNumber());
                                conclution.setSubitemId(subitem.getSubitemId());
                                conclution.setDepartmentId(project.getDepartmentId());
                                mapper.insertSubSelective(conclution);
                            }
                        }
                    }else {
                        PhyProject phyProject = mapper.selectProByPrimaryKey(context.getProjectId());
                        List<PhySubitem> subitems = mapper.selectAllByProjectId(context.getProjectId());
                        for (PhySubitem subitem : subitems) {
                            PhySubitemConclution conclution = new PhySubitemConclution();
                            conclution.setOrderNameber(vo.getOrderNumber());
                            conclution.setSubitemId(subitem.getSubitemId());
                            conclution.setDepartmentId(phyProject.getDepartmentId());
                            mapper.insertSubSelective(conclution);
                        }
                    }
                }
                PhyConclution allConclution = new PhyConclution();
                allConclution.setOrderNumber(vo.getOrderNumber());
                mapper.insertOrderSelective(allConclution);

                PhyStatementLog log = new PhyStatementLog();
                log.setPatientId(vo.getPatientId());
                log.setStatementLogNum(vo.getOrderPrice().negate());
                mapper.addLogs(log);

                return ResponseDTO.success(i1);
            }
        } catch (Exception e) {
            System.out.println("checkOutOrder回滚回滚");
            return ResponseDTO.fail();
        }
    }


    @Override
    public ResponseDTO getOrderIndex(PhyOrder vo) {
        List<SubitemConclutionAndSubitem> orderNumber = mapper.getOrderNumber(vo.getOrderNumber());
        return ResponseDTO.success(orderNumber);
    }

    @Override
    public ResponseDTO getOrderConclution(PhyOrder vo) {
        PhyConclution orderConclution = mapper.getOrderConclution(vo.getOrderNumber());
        return ResponseDTO.success(orderConclution);
    }

    @Override
    public ResponseDTO addBudget(PhyPatient vo) {
        Integer integer = mapper.addBudget(vo);
        return ResponseDTO.success(integer);
    }

    @Override
    public ResponseDTO getNewInfo(PhyPatient vo) {
        HashMap<String,Object> data = new HashMap<>();
        PhyPatient patient = mapper.selectByPrimaryKey(vo.getPatientId());
        data.put("adminInfo",patient);
        String token = JwtUtil.generateToken(data);
        return ResponseDTO.success(token);
    }

    @Override
    public ResponseDTO addlog(PhyStatementLog log) {
        int i = mapper.addLogs(log);
        return ResponseDTO.success(i);
    }
}
