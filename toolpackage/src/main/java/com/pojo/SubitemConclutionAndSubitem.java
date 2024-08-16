package com.pojo;

import lombok.Data;

/**
 * @author 李璟瑜
 * @date 2024/8/15 10:05
 * @description:
 */
@Data
public class SubitemConclutionAndSubitem {
    /**
     * id
     */
    private Integer subitemId;

    /**
     * 名字
     */
    private String subitemName;

    /**
     * 标准值最小
     */
    private String subitemStandardMin;

    /**
     * 标准值最大
     */
    private String subitemStandardMax;

    /**
     * 单位
     */
    private String subitemUnit;

    /**
     * 状态  1开启 0隐藏
     */
    private Integer subitemStatus;

    private Integer subitemConclutionId;

    private Integer departmentId;

    /**
     * 订单编号
     */
    private String orderNameber;

    private String subitemConclution;
}
