package com.mapper;

import com.pojo.PhyPermission;

/**
 * @author 李璟瑜
 * @date 2024/8/8 10:57
 * @description:
 */
public interface PhyPermissionMapper {
    int deleteByPrimaryKey(Integer permissionId);

    int insert(PhyPermission record);

    int insertSelective(PhyPermission record);

    PhyPermission selectByPrimaryKey(Integer permissionId);

    int updateByPrimaryKeySelective(PhyPermission record);

    int updateByPrimaryKey(PhyPermission record);
}