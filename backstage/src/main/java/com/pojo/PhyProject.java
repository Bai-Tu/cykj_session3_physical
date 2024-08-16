package com.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import lombok.Data;

/**
 * @author 李璟瑜
 * @date 2024/8/12 14:11
 * @description:
 */
@Data
public class PhyProject {
    /**
     * id
     */
    private Integer projectId;

    /**
     * 项目名
     */
    private String projectName;

    /**
     * 项目价格
     */
    private BigDecimal projectPrice;

    /**
     * 项目状态
     */
    private Integer projectStatus;

    private Integer departmentId;
    private List<PhySubitem> subitems=new ArrayList<>();
}