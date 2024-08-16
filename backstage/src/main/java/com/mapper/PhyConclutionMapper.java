package com.mapper;

import com.pojo.PhyConclution;

import java.util.List;

/**
 * @author 李璟瑜
 * @date 2024/8/15 12:51
 * @description:
 */
public interface PhyConclutionMapper {
    int deleteByPrimaryKey(Integer conclutionId);

    int insert(PhyConclution record);

    int insertSelective(PhyConclution record);

    PhyConclution selectByPrimaryKey(Integer conclutionId);

    int updateByPrimaryKeySelective(PhyConclution record);

    int updateByPrimaryKey(PhyConclution record);
    PhyConclution getConclutionByOrderNumber(String number);
    int updateByOrderNumber(PhyConclution conclution);
}