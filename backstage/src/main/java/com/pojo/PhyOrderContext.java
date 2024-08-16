package com.pojo;

import lombok.Data;

/**
 * @author 李璟瑜
 * @date 2024/8/14 9:54
 * @description:
 */
@Data
public class PhyOrderContext {
    private Integer orderContextId;

    private String orderNumber;

    private Integer comboId;

    private Integer projectId;
}