package com.mapper;

import com.pojo.PhyRole;

import java.util.List;

/**
 * @author 李璟瑜
 * @date 2024/8/8 10:57
 * @description:
 */
public interface PhyRoleMapper {
    int deleteByPrimaryKey(Integer roleId);

    int insert(PhyRole record);

    int insertSelective(PhyRole record);

    PhyRole selectByPrimaryKey(Integer roleId);

    int updateByPrimaryKeySelective(PhyRole record);

    int updateByPrimaryKey(PhyRole record);
    List<PhyRole> getAllRole();
}