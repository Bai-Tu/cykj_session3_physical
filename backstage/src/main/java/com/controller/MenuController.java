package com.controller;

import com.mapper.PhyMenuMapper;
import com.pojo.PhyMenu;
import com.pojo.PhyRole;
import com.service.MenuService;
import com.util.ResponseDTO;
import com.vo.AuthorityPermissionVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 李璟瑜
 * @date 2024/8/8 10:39
 * @description:
 */
@Controller
@RequestMapping("/menu")
public class MenuController {
    @Autowired
    MenuService service;

    @ResponseBody
    @RequestMapping("/searchMenuByRoleInTree")
    public ResponseDTO searchMenuByRoleInTree(@RequestBody PhyRole role){
        ResponseDTO responseDTO = service.searchMenuByRoleInTree(role.getRoleId());
        return responseDTO;
    }

    @ResponseBody
    @RequestMapping("/getDifferentTree")
    public ResponseDTO getDifferentTree(@RequestBody PhyRole role){
        ResponseDTO responseDTO = service.getDifferenceTree(role.getRoleId());
        return responseDTO;
    }

    @ResponseBody
    @RequestMapping("/searchMenuByRoleInEletree")
    public ResponseDTO searchMenuByRoleInEletree(@RequestBody PhyRole role){
        ResponseDTO responseDTO = service.searchMenuByRoleInEletree((int) role.getRoleId());
        return responseDTO;
    }

    @ResponseBody
    @RequestMapping("/editMenuAuthority")
    public ResponseDTO editMenuAuthority(@RequestBody AuthorityPermissionVo vo){
        ResponseDTO responseDTO = service.editMenuAuthority(vo.getRoleId(), vo.getMenuData());
        return responseDTO;
    }

    @ResponseBody
    @RequestMapping("/searchMenuByRoleInTreeNoPage")
    public ResponseDTO searchMenuByRoleInTreeNoPage(){
        ResponseDTO responseDTO = service.searchMenuByRoleInTreeNoPage();
        return responseDTO;
    }

    @ResponseBody
    @RequestMapping("/switchMenuStatus")
    public ResponseDTO switchMenuStatus(@RequestBody PhyMenu vo){
        ResponseDTO responseDTO = service.switchMenuStatus(vo);
        return responseDTO;
    }


}
