package com.controller;

import com.pojo.PhyProject;
import com.service.ProjectSubitemService;
import com.util.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 李璟瑜
 * @date 2024/8/11 21:59
 * @description:
 */
@Controller
@RequestMapping("/project-subitem")
public class ProjectSubitemController {

    @Autowired
    ProjectSubitemService service;

    @ResponseBody
    @RequestMapping("/getSubitemById")
    public ResponseDTO getSubitemById(@RequestBody PhyProject vo){
        ResponseDTO responseDTO = service.getSubitemById(vo.getProjectId());
        return responseDTO;
    }

}
