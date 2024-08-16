package com.vo;

import com.pojo.MenuTree;
import com.pojo.PhyMenu;
import lombok.Data;

import java.util.ArrayList;

/**
 * @author 李璟瑜
 * @date 2024/8/9 12:48
 * @description:
 */
@Data
public class AuthorityPermissionVo {
    private int roleId;
    private ArrayList<MenuTree> menuData = new ArrayList<>();
}
