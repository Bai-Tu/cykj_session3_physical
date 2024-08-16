package com.pojo;

import lombok.Data;

/**
 * @author 李璟瑜
 * @date 2024/8/8 10:57
 * @description:
 */
@Data
public class PhyProjectSubitemConnect {
    /**
    * id
    */
    private Integer projectSubitemConnectId;

    /**
    * 项目id
    */
    private Integer projectId;

    /**
    * 子项id
    */
    private Integer subitemId;
}