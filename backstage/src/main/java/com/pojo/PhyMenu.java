package com.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import lombok.Data;

/**
 * @author 李璟瑜
 * @date 2024/8/8 10:57
 * @description:
 */
@Data
public class PhyMenu {
    /**
    * id
    */
    private Integer menuId;

    /**
    * 菜单名
    */
    private String menuName;

    /**
    * 菜单路由地址
    */
    private String menuPath;

    /**
    * 菜单图标名
    */
    private String menuIcon;

    /**
    * 1开启 0 关闭
    */
    private Integer menuStatus;

    /**
    * 父级菜单id
    */
    private Integer menuParentId;

    /**
    * 是否隐藏 1开启 0关闭
    */
    private Integer menuIsHidden;

    /**
    * 层级，数值越大排序越高
    */
    private Integer menuSort;

    /**
    * 创建时间
    */
    private Date menuCreatTime;

    /**
    * 修改时间
    */
    private Date menuUpdateTime;
    private List<PhyMenu> children =new ArrayList<>();
}