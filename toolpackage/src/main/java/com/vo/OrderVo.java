package com.vo;

import com.pojo.PhyCombo;
import com.pojo.PhyProject;
import lombok.Data;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 李璟瑜
 * @date 2024/8/14 14:26
 * @description:
 */
@Data
public class OrderVo {
    private List<PhyProject> projects = new ArrayList<>();
    private List<PhyCombo> combos = new ArrayList<>();
    private int patientId;
    private String orderNumber;
    private BigDecimal price;

}
