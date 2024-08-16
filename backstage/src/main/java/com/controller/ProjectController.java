package com.controller;

import com.pojo.PhyCombo;
import com.pojo.PhyComboProjectConnet;
import com.pojo.PhyProject;
import com.service.ProjectService;
import com.util.ResponseDTO;
import com.vo.PageVo;
import com.vo.SearchPageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 李璟瑜
 * @date 2024/8/11 21:28
 * @description:
 */
@Controller
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    ProjectService service;

    @ResponseBody
    @RequestMapping("/getAllProject")
    public ResponseDTO getAllProject(@RequestBody PageVo vo){
        ResponseDTO responseDTO = service.getAllProject(vo);
        return responseDTO;
    }

    @ResponseBody
    @RequestMapping("/searchProject")
    public ResponseDTO searchProject(@RequestBody SearchPageVo vo){
        ResponseDTO responseDTO = service.searchProject(vo);
        return responseDTO;
    }

    @ResponseBody
    @RequestMapping("/addProject")
    public ResponseDTO addProject(@RequestBody PhyProject vo){
        ResponseDTO responseDTO = service.addProject(vo);
        return responseDTO;
    }

    @ResponseBody
    @RequestMapping("/editProject")
    public ResponseDTO editProject(@RequestBody PhyProject vo){
        ResponseDTO responseDTO = service.editProject(vo);
        return responseDTO;
    }

    @ResponseBody
    @RequestMapping("/switchProjectStatus")
    public ResponseDTO switchProjectStatus(@RequestBody PhyProject vo){
        ResponseDTO responseDTO = service.switchProjectStatus(vo);
        return responseDTO;
    }

    @ResponseBody
    @RequestMapping("/getAllProjectNoPage")
    public ResponseDTO getAllProjectNoPage(){
        ResponseDTO responseDTO = service.getAllProjectNoPage();
        return responseDTO;
    }

    @ResponseBody
    @RequestMapping("/getDiffProject")
    public ResponseDTO getDiffProject(@RequestBody PhyCombo vo){
        ResponseDTO responseDTO = service.getDiffProject(vo.getComboId());
        return responseDTO;
    }

    @ResponseBody
    @RequestMapping("/getAllProjectWithStatus")
    public ResponseDTO getAllProjectWithStatus(@RequestBody PhyProject vo){
        ResponseDTO responseDTO = service.getAllProjectWithStatus(vo.getProjectStatus());
        return responseDTO;
    }


}
