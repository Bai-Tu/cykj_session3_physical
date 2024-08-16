package com.mapper;

import com.pojo.PhyAdmin;
import com.pojo.PhyDepartment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 李璟瑜
 * @date 2024/8/8 15:20
 * @description:
 */
public interface PhyDepartmentMapper {
    int deleteByPrimaryKey(Integer departmentId);

    int insert(PhyDepartment record);

    int insertSelective(PhyDepartment record);

    PhyDepartment selectByPrimaryKey(Integer departmentId);

    int updateByPrimaryKeySelective(PhyDepartment record);

    int updateByPrimaryKey(PhyDepartment record);

    List<PhyDepartment> getAllDepartment();
    int switchDepartmentStatus(@Param("id")int departmentId,@Param("status") int status);
    List<PhyDepartment> getDepartmentInSearch(String departmentName);
    List<PhyDepartment> selectByDepartmentName(@Param("departmentName")String departmentName);

    List<PhyAdmin> selectAdminByDepartmentId(int departentId);
}