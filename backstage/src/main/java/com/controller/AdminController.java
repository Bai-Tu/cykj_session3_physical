package com.controller;

import com.annotation.Logable;
import com.pojo.PhyAdmin;
import com.service.AdminService;
import com.util.ResponseDTO;
import com.vo.ChangePwdVo;
import com.vo.LoginVo;
import com.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @Logable
    @ResponseBody
    @PostMapping("/adminLogin")
    public ResponseDTO adminLogin(@RequestBody LoginVo vo){
        ResponseDTO responseDTO = service.adminLogin(vo);
        return responseDTO;
    }


    @ResponseBody
    @PostMapping("/getAllAdmin")
    public ResponseDTO getAllAdmin(@RequestBody PageVo vo){
        ResponseDTO responseDTO = service.getAllAdmin(vo);
        return responseDTO;
    }

    @Logable
    @ResponseBody
    @PostMapping("/resetPwd")
    public ResponseDTO resetPwd(@RequestBody PhyAdmin vo){
        ResponseDTO responseDTO = service.resetPwd(vo);
        return responseDTO;
    }

    @Logable
    @ResponseBody
    @PostMapping("/addAdmin")
    public ResponseDTO addAdmin(@RequestBody PhyAdmin vo){
        ResponseDTO responseDTO = service.addAdmin(vo);
        return responseDTO;
    }

    @Logable
    @ResponseBody
    @PostMapping("/editAdmin")
    public ResponseDTO editAdmin(@RequestBody PhyAdmin vo){
        ResponseDTO responseDTO = service.editAdmin(vo);
        return responseDTO;
    }

    @ResponseBody
    @PostMapping("/getAdminOtherInfo")
    public ResponseDTO getAdminOtherInfo(@RequestBody PhyAdmin role){
        ResponseDTO responseDTO = service.getAdminOtherInfo(role.getAdminRoleId());
        return responseDTO;
    }

    @Logable
    @ResponseBody
    @PostMapping("/changePwd")
    public ResponseDTO changePwd(@RequestBody ChangePwdVo vo){
        ResponseDTO responseDTO = service.changePwd(vo);
        return responseDTO;
    }

}
