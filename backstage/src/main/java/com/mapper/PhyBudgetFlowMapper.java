package com.mapper;

import com.pojo.PhyBudgetFlow;

/**
 * @author 李璟瑜
 * @date 2024/8/8 10:57
 * @description:
 */
public interface PhyBudgetFlowMapper {
    int deleteByPrimaryKey(Integer budgetFlowId);

    int insert(PhyBudgetFlow record);

    int insertSelective(PhyBudgetFlow record);

    PhyBudgetFlow selectByPrimaryKey(Integer budgetFlowId);

    int updateByPrimaryKeySelective(PhyBudgetFlow record);

    int updateByPrimaryKey(PhyBudgetFlow record);
}