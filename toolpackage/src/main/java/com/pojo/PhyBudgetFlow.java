package com.pojo;

import lombok.Data;

import java.util.Date;

/**
 * @author 李璟瑜
 * @date 2024/8/8 10:57
 * @description:
 */
@Data
public class PhyBudgetFlow {
    private Integer budgetFlowId;

    private Integer patientId;

    private String edittingBudget;

    private Date budgetFlowCreateTime;
}