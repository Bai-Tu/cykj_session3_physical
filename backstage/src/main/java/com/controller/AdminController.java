package com.controller;

import com.pojo.PhyAdmin;
import com.service.AdminService;
import com.util.ResponseDTO;
import com.vo.LoginVo;
import com.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 李璟瑜
 * @date 2024/8/7 15:19
 * @description:
 */
@CrossOrigin
@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    AdminService service;

    @ResponseBody
    @RequestMapping("/adminLogin")
    public ResponseDTO adminLogin(@RequestBody LoginVo vo){
        ResponseDTO responseDTO = service.adminLogin(vo);
        return responseDTO;
    }

    @ResponseBody
    @RequestMapping("/getAllAdmin")
    public ResponseDTO getAllAdmin(@RequestBody PageVo vo){
        ResponseDTO responseDTO = service.getAllAdmin(vo);
        return responseDTO;
    }

    @ResponseBody
    @RequestMapping("/resetPwd")
    public ResponseDTO resetPwd(@RequestBody PhyAdmin vo){
        ResponseDTO responseDTO = service.resetPwd(vo);
        return responseDTO;
    }

    @ResponseBody
    @RequestMapping("/addAdmin")
    public ResponseDTO addAdmin(@RequestBody PhyAdmin vo){
        ResponseDTO responseDTO = service.addAdmin(vo);
        return responseDTO;
    }

    @ResponseBody
    @RequestMapping("/editAdmin")
    public ResponseDTO editAdmin(@RequestBody PhyAdmin vo){
        ResponseDTO responseDTO = service.editAdmin(vo);
        return responseDTO;
    }

    @ResponseBody
    @RequestMapping("/getAdminOtherInfo")
    public ResponseDTO getAdminOtherInfo(@RequestBody PhyAdmin role){
        ResponseDTO responseDTO = service.getAdminOtherInfo(role.getAdminRoleId());
        return responseDTO;
    }

}
