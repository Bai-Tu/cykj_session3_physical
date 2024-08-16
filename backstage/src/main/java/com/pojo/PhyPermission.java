package com.pojo;

import lombok.Data;

/**
 * @author 李璟瑜
 * @date 2024/8/8 10:57
 * @description:
 */
@Data
public class PhyPermission {
    /**
    * id
    */
    private Integer permissionId;

    /**
    * 角色id
    */
    private Integer roleId;

    /**
    * 菜单id
    */
    private Integer menuId;
}