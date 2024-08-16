package com.mapper;

import com.pojo.PhyReport;

/**
 * @author 李璟瑜
 * @date 2024/8/8 10:57
 * @description:
 */
public interface PhyReportMapper {
    int deleteByPrimaryKey(Integer reportId);

    int insert(PhyReport record);

    int insertSelective(PhyReport record);

    PhyReport selectByPrimaryKey(Integer reportId);

    int updateByPrimaryKeySelective(PhyReport record);

    int updateByPrimaryKey(PhyReport record);
}