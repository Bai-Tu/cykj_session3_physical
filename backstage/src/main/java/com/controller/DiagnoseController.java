package com.controller;

import com.pojo.PhySubitemConclution;
import com.service.DiagnoseService;
import com.util.ResponseDTO;
import com.vo.SearchPageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 李璟瑜
 * @date 2024/8/15 10:07
 * @description:
 */
@Controller
@RequestMapping("/diagnose")
public class DiagnoseController {

    @Autowired
    DiagnoseService service;


    @ResponseBody
    @RequestMapping("/getOrderContextByNumberByPage")
    public ResponseDTO getOrderContextByNumberByPage(@RequestBody SearchPageVo vo){
        ResponseDTO responseDTO = service.getOrderContextByNumberByPage(vo);
        return responseDTO;
    }

    @ResponseBody
    @RequestMapping("/updateConclution")
    public ResponseDTO updateConclution(@RequestBody PhySubitemConclution vo){
        ResponseDTO responseDTO = service.updateConclution(vo);
        return responseDTO;
    }

}
