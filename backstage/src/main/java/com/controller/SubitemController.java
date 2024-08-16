package com.controller;

import com.pojo.PhyProject;
import com.pojo.PhySubitem;
import com.service.SubitemService;
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
 * @date 2024/8/9 20:34
 * @description:
 */
@Controller
@RequestMapping("/subitem")
public class SubitemController {
    @Autowired
    SubitemService service;

    @ResponseBody
    @RequestMapping("/getAllSubitem")
    public ResponseDTO getAllSubitem(@RequestBody PageVo vo){
        ResponseDTO responseDTO = service.getAllSubitem(vo);
        return responseDTO;
    }

    @ResponseBody
    @RequestMapping("/insertSubitem")
    public ResponseDTO insertSubitem(@RequestBody PhySubitem subitem){
        ResponseDTO responseDTO = service.insertSubitem(subitem);
        return responseDTO;
    }

    @ResponseBody
    @RequestMapping("/editSubitem")
    public ResponseDTO editSubitem(@RequestBody PhySubitem subitem){
        ResponseDTO responseDTO = service.editSubitem(subitem);
        return responseDTO;
    }

    @ResponseBody
    @RequestMapping("/getSubitemInSearch")
    public ResponseDTO getSubitemInSearch(@RequestBody SearchPageVo vo){
        ResponseDTO responseDTO = service.searchSubitem(vo);
        return responseDTO;
    }

    @ResponseBody
    @RequestMapping("/editSubitemStatus")
    public ResponseDTO editSubitemStatus(@RequestBody PhySubitem subitem){
        ResponseDTO responseDTO = service.editSubitemStatus(subitem);
        return responseDTO;
    }

    @ResponseBody
    @RequestMapping("/getDiffSubitem")
    public ResponseDTO getDiffSubitem(@RequestBody PhyProject project){
        ResponseDTO responseDTO = service.getDiffSubitem(project.getProjectId());
        return responseDTO;
    }

    @ResponseBody
    @RequestMapping("/getAllSubitemNoVo")
    public ResponseDTO getAllSubitemNoVo(){
        ResponseDTO responseDTO = service.getAllSubitemNoVo();
        return responseDTO;
    }

    @ResponseBody
    @RequestMapping("/getAllSubitemNoVoWithStatus")
    public ResponseDTO getAllSubitemNoVoWithStatus(@RequestBody PhySubitem vo){
        ResponseDTO responseDTO = service.getAllSubitemNoVoWithStatus(vo.getSubitemStatus());
        return responseDTO;
    }

    @ResponseBody
    @RequestMapping("/getDiffSubitemWithStatus")
    public ResponseDTO getDiffSubitemWithStatus(@RequestBody PhyProject vo){
        ResponseDTO responseDTO = service.getDiffSubitemWithStatus(vo);
        return responseDTO;
    }


}
