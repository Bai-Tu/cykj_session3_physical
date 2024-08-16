package com.pojo;

import lombok.Data;

import java.util.Date;

/**
 * @author 李璟瑜
 * @date 2024/8/8 10:57
 * @description:
 */
@Data
public class PhyReport {
    private Integer reportId;

    private String orderNumber;

    private String reportContext;

    private Integer adminId;

    private Date reportCreateTime;
}