package com.controller;

import com.service.DataService;
import com.util.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 李璟瑜
 * @date 2024/8/22 11:01
 * @description:
 */
@Controller
@RequestMapping("/data")
public class DataController {
    @Autowired
    DataService service;

    @ResponseBody
    @RequestMapping("/getAgeData")
    public ResponseDTO getAgeData(){
        ResponseDTO responseDTO = service.getAgeData();
        return responseDTO;
    }

    @ResponseBody
    @RequestMapping("/getSaleData")
    public ResponseDTO getSaleData(){
        ResponseDTO responseDTO = service.getSaleData();
        return responseDTO;
    }

}
