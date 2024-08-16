package com.mapper;

import com.pojo.PhyLog;

/**
 * @author 李璟瑜
 * @date 2024/8/8 10:57
 * @description:
 */
public interface PhyLogMapper {
    int deleteByPrimaryKey(Integer logId);

    int insert(PhyLog record);

    int insertSelective(PhyLog record);

    PhyLog selectByPrimaryKey(Integer logId);

    int updateByPrimaryKeySelective(PhyLog record);

    int updateByPrimaryKey(PhyLog record);
}