package com.pojo;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author 李璟瑜
 * @date 2024/8/14 9:11
 * @description:
 */
@Data
public class PhyOrder {
    private Integer orderId;

    private String orderNumber;

    private Integer patientId;

    private Date orderCreateTime;

    private String orderStatus;

    private BigDecimal orderPrice;
}