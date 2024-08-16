package com.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mapper.PhyDepartmentMapper;
import com.pojo.PhyAdmin;
import com.pojo.PhyDepartment;
import com.service.DepartmentService;
import com.util.ResponseDTO;
import com.vo.SearchPageVo;
import com.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 李璟瑜
 * @date 2024/8/8 15:11
 * @description:
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    PhyDepartmentMapper mapper;

    /*
    * 获得所有科室信息
    * */
    @Override
    public ResponseDTO getAllDepartment(PageVo vo) {
        PageHelper.startPage(vo.getPagen(), vo.getLimit());
        List<PhyDepartment> allDepartment = mapper.getAllDepartment();
        PageInfo<PhyDepartment> pageInfo = new PageInfo<>(allDepartment);
        return ResponseDTO.success(pageInfo);
    }

    /*
    * 修改科室状态
    * */
    @Override
    public ResponseDTO switchDepartmentStatus(PhyDepartment department) {
        int i = 0;
        List<PhyAdmin> phyAdmins = mapper.selectAdminByDepartmentId(department.getDepartmentId());
        if (phyAdmins.size()!=0){
            return new ResponseDTO(-2,"还有医生",null);
        }

        if (department.getDepartmentStatus() == 1){
            i = mapper.switchDepartmentStatus(department.getDepartmentId(), 0);
        }else {
            i = mapper.switchDepartmentStatus(department.getDepartmentId(), 1);
        }

        if (i>0){
            return ResponseDTO.success();
        }
        return ResponseDTO.fail();
    }

    /*
    * 模糊搜索科室
    * */
    @Override
    public ResponseDTO getDepartmentInSearch(SearchPageVo vo) {
        PageHelper.startPage(vo.getPagen(), vo.getLimit());
        List<PhyDepartment> departmentInSearch = mapper.getDepartmentInSearch(vo.getName());
        PageInfo<PhyDepartment> pageInfo = new PageInfo<>(departmentInSearch);
        return ResponseDTO.success(pageInfo);
    }

    /*
    * 添加科室
    * */
    @Override
    public ResponseDTO addDepartment(PhyDepartment department) {
        List<PhyDepartment> phyDepartments = mapper.selectByDepartmentName(department.getDepartmentName());
        if (phyDepartments.size() == 0){
            int insert = mapper.insert(department);
            if (insert > 0){
                return ResponseDTO.success();
            }else {
                return ResponseDTO.fail();
            }
        }else {
            return new ResponseDTO(-100,"已存在",null);
        }
    }

    @Override
    public ResponseDTO editDepartment(PhyDepartment department) {
        int i = mapper.updateByPrimaryKeySelective(department);
        if (i>0){
            return ResponseDTO.success();
        }else {
            return ResponseDTO.fail();
        }
    }
}
