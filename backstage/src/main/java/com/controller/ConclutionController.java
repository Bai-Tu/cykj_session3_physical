package com.controller;

import com.pojo.PhyConclution;
import com.service.ConclutionService;
import com.util.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 李璟瑜
 * @date 2024/8/15 14:16
 * @description:
 */
@Controller
@RequestMapping("/conclution")
public class ConclutionController {
    @Autowired
    ConclutionService service;

    @ResponseBody
    @RequestMapping("/getConclutionByOrderNumber")
    public ResponseDTO getConclutionByOrderNumber(@RequestBody PhyConclution vo){
        ResponseDTO responseDTO = service.getConclutionByOrderNumber(vo);
        return responseDTO;
    }

    @ResponseBody
    @RequestMapping("/setConclution")
    public ResponseDTO setConclution(@RequestBody PhyConclution vo){
        ResponseDTO responseDTO = service.setConclution(vo);
        return responseDTO;
    }


}
