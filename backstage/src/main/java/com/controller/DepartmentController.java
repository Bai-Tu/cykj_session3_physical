package com.controller;

import com.annotation.Logable;
import com.pojo.PhyDepartment;
import com.service.DepartmentService;
import com.util.ResponseDTO;
import com.vo.SearchPageVo;
import com.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
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
    @PostMapping("/getAllDepartment")
    public ResponseDTO getAllDepartment(@RequestBody PageVo vo){
        ResponseDTO responseDTO = service.getAllDepartment(vo);
        return responseDTO;
    }

    @ResponseBody
    @PostMapping("/getDepartmentInSearch")
    public ResponseDTO getDepartmentInSearch(@RequestBody SearchPageVo vo){
        ResponseDTO responseDTO = service.getDepartmentInSearch(vo);
        return responseDTO;
    }

    @Logable
    @ResponseBody
    @PostMapping("/switchDepartmentStatus")
    public ResponseDTO switchDepartmentStatus(@RequestBody PhyDepartment vo){
        ResponseDTO responseDTO = service.switchDepartmentStatus(vo);
        return responseDTO;
    }

    @Logable
    @ResponseBody
    @PostMapping("/addDepartment")
    public ResponseDTO addDepartment(@RequestBody PhyDepartment vo){
        ResponseDTO responseDTO = service.addDepartment(vo);
        return responseDTO;
    }

    @Logable
    @ResponseBody
    @PostMapping("/editDepartment")
    public ResponseDTO editDepartment(@RequestBody PhyDepartment vo){
        ResponseDTO responseDTO = service.editDepartment(vo);
        return responseDTO;
    }

}
