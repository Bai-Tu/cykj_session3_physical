package com.pojo;

import lombok.Data;

/**
 * @author 李璟瑜
 * @date 2024/8/8 10:57
 * @description:
 */
@Data
public class PhyComboProjectConnet {
    /**
    * 套餐-项目 id
    */
    private Integer comboProjectConnetId;

    /**
    * 套餐id
    */
    private Integer comboId;

    /**
    * 项目id
    */
    private Integer projectId;
}