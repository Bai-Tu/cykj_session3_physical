package com.controller;

import com.pojo.PhyRole;
import com.service.RoleService;
import com.util.ResponseDTO;
import com.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 李璟瑜
 * @date 2024/8/8 14:05
 * @description:
 */
@Controller
@RequestMapping("/role")
public class RoleController {
    @Autowired
    RoleService service;

    @ResponseBody
    @RequestMapping("/getAllRole")
    public ResponseDTO getAllRole(@RequestBody PageVo vo){
        ResponseDTO responseDTO = service.getAllRole(vo);
        return responseDTO;
    }

    @ResponseBody
    @RequestMapping("/addRole")
    public ResponseDTO addRole(@RequestBody PhyRole vo){
        ResponseDTO responseDTO = service.addRole(vo);
        return responseDTO;
    }

}
