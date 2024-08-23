package com.controller;

import com.annotation.Logable;
import com.pojo.PhyCombo;
import com.pojo.PhyComboProjectConnet;
import com.pojo.PhyProject;
import com.service.ProjectService;
import com.util.ResponseDTO;
import com.vo.PageVo;
import com.vo.SearchPageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
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
    @PostMapping("/getAllProject")
    public ResponseDTO getAllProject(@RequestBody PageVo vo){
        ResponseDTO responseDTO = service.getAllProject(vo);
        return responseDTO;
    }

    @ResponseBody
    @PostMapping("/searchProject")
    public ResponseDTO searchProject(@RequestBody SearchPageVo vo){
        ResponseDTO responseDTO = service.searchProject(vo);
        return responseDTO;
    }

    @Logable
    @ResponseBody
    @PostMapping("/addProject")
    public ResponseDTO addProject(@RequestBody PhyProject vo){
        ResponseDTO responseDTO = service.addProject(vo);
        return responseDTO;
    }

    @Logable
    @ResponseBody
    @PostMapping("/editProject")
    public ResponseDTO editProject(@RequestBody PhyProject vo){
        ResponseDTO responseDTO = service.editProject(vo);
        return responseDTO;
    }

    @Logable
    @ResponseBody
    @PostMapping("/switchProjectStatus")
    public ResponseDTO switchProjectStatus(@RequestBody PhyProject vo){
        ResponseDTO responseDTO = service.switchProjectStatus(vo);
        return responseDTO;
    }

    @ResponseBody
    @PostMapping("/getAllProjectNoPage")
    public ResponseDTO getAllProjectNoPage(){
        ResponseDTO responseDTO = service.getAllProjectNoPage();
        return responseDTO;
    }

    @ResponseBody
    @PostMapping("/getDiffProject")
    public ResponseDTO getDiffProject(@RequestBody PhyCombo vo){
        ResponseDTO responseDTO = service.getDiffProject(vo.getComboId());
        return responseDTO;
    }

    @ResponseBody
    @PostMapping("/getAllProjectWithStatus")
    public ResponseDTO getAllProjectWithStatus(@RequestBody PhyProject vo){
        ResponseDTO responseDTO = service.getAllProjectWithStatus(vo.getProjectStatus());
        return responseDTO;
    }


}
