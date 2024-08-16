package com.service.impl;

import com.mapper.PhyMenuMapper;
import com.mapper.PhyPermissionMapper;
import com.pojo.MenuTree;
import com.pojo.PhyMenu;
import com.pojo.PhyPermission;
import com.service.MenuService;
import com.util.ListInTree;
import com.util.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author 李璟瑜
 * @date 2024/8/8 11:02
 * @description:
 */
@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    PhyMenuMapper mapper;

    @Autowired
    PhyPermissionMapper permissionMapper;

    @Override
    public ResponseDTO searchMenuByRoleInTree(int roleId) {
        List<PhyMenu> phyMenus = mapper.searchMenuByRole(roleId);
        ArrayList<PhyMenu> phyMenusInTree = ListInTree.turnToTree(phyMenus);
        return ResponseDTO.success(phyMenusInTree);
    }

    @Override
    public ResponseDTO getDifferenceTree(int roleId) {
        ArrayList<MenuTree> menuData = new ArrayList<>();
        List<PhyMenu> mixList = new ArrayList<>();
        List<PhyMenu> differentMenu = mapper.getDifferentTree(roleId);
        List<PhyMenu> Menus = mapper.searchAllNotHidden();
        Map<Integer, PhyMenu> collect = Menus.stream().collect(Collectors.toMap(PhyMenu::getMenuId, CyMenu -> CyMenu));

        for (PhyMenu menu : differentMenu) {
            if (menu.getMenuParentId()!=0){
                PhyMenu menuById = collect.get(menu.getMenuParentId());
                if (!differentMenu.contains(menuById)) {
                    if(mixList.contains(menuById)){
                        continue;
                    }
                    mixList.add(menuById);
                }
            }
        }
        differentMenu.addAll(mixList);

        //遍历成tree类型
        for (PhyMenu menu : differentMenu) {
            if (menu.getMenuParentId() == 0){
                MenuTree menuTree = new MenuTree(menu);
                menuTree.setPid(0);
                menuData.add(getChildMenuInEletree(menuTree,differentMenu));
            }
        }
        return ResponseDTO.success(menuData);
    }
    public MenuTree getChildMenuInEletree(MenuTree nowMenu,List<PhyMenu> allMenu){
        List<MenuTree> children = new ArrayList<>();
        for (PhyMenu menu : allMenu) {
            if (Integer.valueOf(nowMenu.getId()) == (int)menu.getMenuParentId()){
                MenuTree tree = new MenuTree(menu);
                tree.setPid(Integer.valueOf(nowMenu.getId()));
                children.add(getChildMenuInEletree(tree,allMenu));
            }
        }
        nowMenu.setChildren(children);
        return nowMenu;
    }

    @Override
    public ResponseDTO searchMenuByRoleInEletree(int roleId) {
        ArrayList<MenuTree> menuData = new ArrayList<>();
        List<PhyMenu> cyMenus = mapper.searchMenuByRole(roleId);
        List<PhyMenu> allMenu = mapper.searchAllNotHidden();
        List<PhyMenu> mixList = new ArrayList<>();
        Map<Integer, PhyMenu> collect = allMenu.stream().collect(Collectors.toMap(PhyMenu::getMenuId, CyMenu -> CyMenu));
        for (PhyMenu menu : cyMenus) {
            if (menu.getMenuParentId()!=0){
                PhyMenu menuById = collect.get(menu.getMenuParentId());
                if (!allMenu.contains(menuById)) {
                    if(mixList.contains(menuById)){
                        continue;
                    }
                    mixList.add(menuById);
                }
            }
        }
        cyMenus.addAll(mixList);

        for (PhyMenu Menu : cyMenus) {
            if (Menu.getMenuParentId() == 0){
                MenuTree menuTree = new MenuTree(Menu);
                menuTree.setPid(0);
                menuData.add(getChildMenuInEletree(menuTree,cyMenus));
            }
        }
        return ResponseDTO.success(menuData);
    }

    @Override
    @Transactional
    public ResponseDTO editMenuAuthority(int roleId, List<MenuTree> menuList) {
        try {
            ArrayList<MenuTree> menuTrees = ListInTree.flattenTree(menuList);
            int i = mapper.deletePermissionByRoleId(roleId);
            for (MenuTree tree : menuTrees) {
                PhyPermission permission = new PhyPermission();
                permission.setRoleId(roleId);
                permission.setMenuId(Integer.valueOf(tree.getId()));
                permissionMapper.insertSelective(permission);
            }
        } catch (NumberFormatException e) {
            return ResponseDTO.fail();
        }
        return ResponseDTO.success();
    }

    @Override
    public ResponseDTO searchMenuByRoleInTreeNoPage() {
        List<PhyMenu> phyMenus = mapper.selectAll();
        ArrayList<PhyMenu> menus = ListInTree.turnToTree(phyMenus);
        return ResponseDTO.success(menus);
    }

    @Override
    public ResponseDTO switchMenuStatus(PhyMenu vo) {
        List<PhyMenu> childMenu = mapper.getChildMenu(vo.getMenuId());
        PhyMenu menu = mapper.selectByPrimaryKey(vo.getMenuId());
        if (childMenu.size() != 0){
            return new ResponseDTO(-2,null,null);
        }
        if (menu.getMenuParentId() == 0 && vo.getMenuStatus() == 1){
            mapper.switchAllChild(vo.getMenuId());
        }
        int i = mapper.updateByPrimaryKeySelective(vo);

        return ResponseDTO.success(i);
    }
}
