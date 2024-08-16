package com.controller;

import com.pojo.PhyComboProjectConnet;
import com.service.ComboProjectService;
import com.util.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 李璟瑜
 * @date 2024/8/12 20:39
 * @description:
 */
@Controller
@RequestMapping("/combo-project")
public class ComboProjectController {

    @Autowired
    ComboProjectService service;

    @ResponseBody
    @RequestMapping("/getProjectByComboId")
    public ResponseDTO getProjectByComboId(@RequestBody PhyComboProjectConnet vo){
        ResponseDTO responseDTO = service.getProjectByComboId(vo.getComboId());
        return responseDTO;
    }

    @ResponseBody
    @RequestMapping("/getSubitemByComboId")
    public ResponseDTO getSubitemByComboId(@RequestBody PhyComboProjectConnet vo){
        ResponseDTO responseDTO = service.getSubitemByComboId(vo.getComboId());
        return responseDTO;
    }

}
