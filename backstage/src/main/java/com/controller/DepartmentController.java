package com.controller;

import com.pojo.PhyDepartment;
import com.service.DepartmentService;
import com.util.ResponseDTO;
import com.vo.SearchPageVo;
import com.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 李璟瑜
 * @date 2024/8/8 15:09
 * @description:
 */
@Controller
@RequestMapping("/department")
public class DepartmentController {
    @Autowired
    DepartmentService service;

    @ResponseBody
    @RequestMapping("/getAllDepartment")
    public ResponseDTO getAllDepartment(@RequestBody PageVo vo){
        ResponseDTO responseDTO = service.getAllDepartment(vo);
        return responseDTO;
    }

    @ResponseBody
    @RequestMapping("/getDepartmentInSearch")
    public ResponseDTO getDepartmentInSearch(@RequestBody SearchPageVo vo){
        ResponseDTO responseDTO = service.getDepartmentInSearch(vo);
        return responseDTO;
    }

    @ResponseBody
    @RequestMapping("/switchDepartmentStatus")
    public ResponseDTO switchDepartmentStatus(@RequestBody PhyDepartment vo){
        ResponseDTO responseDTO = service.switchDepartmentStatus(vo);
        return responseDTO;
    }

    @ResponseBody
    @RequestMapping("/addDepartment")
    public ResponseDTO addDepartment(@RequestBody PhyDepartment vo){
        ResponseDTO responseDTO = service.addDepartment(vo);
        return responseDTO;
    }

    @ResponseBody
    @RequestMapping("/editDepartment")
    public ResponseDTO editDepartment(@RequestBody PhyDepartment vo){
        ResponseDTO responseDTO = service.editDepartment(vo);
        return responseDTO;
    }

}
