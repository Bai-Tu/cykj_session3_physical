package com.service;

import com.pojo.MenuTree;
import com.pojo.PhyMenu;
import com.util.ResponseDTO;

import java.util.List;

/**
 * @author 李璟瑜
 * @date 2024/8/8 10:42
 * @description:
 */
public interface MenuService {
    ResponseDTO searchMenuByRoleInTree(int roleId);
    ResponseDTO getDifferenceTree(int roleId);
    ResponseDTO searchMenuByRoleInEletree(int roleId);
    ResponseDTO editMenuAuthority(int roleId, List<MenuTree> menuList);
    ResponseDTO searchMenuByRoleInTreeNoPage();
    ResponseDTO switchMenuStatus(PhyMenu vo);
}
