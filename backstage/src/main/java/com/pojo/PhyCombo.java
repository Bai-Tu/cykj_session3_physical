package com.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;

/**
 * @author 李璟瑜
 * @date 2024/8/13 8:38
 * @description:
 */
@Data
public class PhyCombo {
    /**
     * 套餐id
     */
    private Integer comboId;

    /**
     * 套餐名
     */
    private String comboName;

    /**
     * 套餐价格
     */
    private BigDecimal comboPrice;

    /**
     * 状态1开启0关闭
     */
    private Integer comboStatus;
    private List<PhyProject> projects = new ArrayList<>();
}