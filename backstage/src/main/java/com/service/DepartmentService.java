package com.service;

import com.pojo.PhyDepartment;
import com.util.ResponseDTO;
import com.vo.SearchPageVo;
import com.vo.PageVo;

/**
 * @author 李璟瑜
 * @date 2024/8/8 15:11
 * @description:
 */
public interface DepartmentService {
    ResponseDTO getAllDepartment(PageVo vo);
    ResponseDTO switchDepartmentStatus(PhyDepartment department);
    ResponseDTO getDepartmentInSearch(SearchPageVo vo);
    ResponseDTO addDepartment(PhyDepartment department);
    ResponseDTO editDepartment(PhyDepartment department);
}
