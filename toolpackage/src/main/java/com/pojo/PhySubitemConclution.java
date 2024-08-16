package com.pojo;

import lombok.Data;

/**
 * @author 李璟瑜
 * @date 2024/8/13 8:39
 * @description:
 */
@Data
public class PhySubitemConclution {
    private Integer subitemConclutionId;

    private Integer subitemId;

    private Integer departmentId;

    /**
     * 订单编号
     */
    private String orderNameber;

    private String subitemConclution;
}