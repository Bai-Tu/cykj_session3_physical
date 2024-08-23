package com.controller;

import com.annotation.Logable;
import com.pojo.PhyCombo;
import com.service.ComboService;
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
 * @date 2024/8/12 20:39
 * @description:
 */
@Controller
@RequestMapping("/combo")
public class ComboController {

    @Autowired
    ComboService service;

    @ResponseBody
    @PostMapping("/getAllComboByPage")
    public ResponseDTO getAllComboByPage(@RequestBody PageVo vo){
        ResponseDTO responseDTO = service.getAllComboByPage(vo);
        return responseDTO;
    }

    @ResponseBody
    @PostMapping("/searchCombo")
    public ResponseDTO searchCombo(@RequestBody SearchPageVo vo){
        ResponseDTO responseDTO = service.searchCombo(vo);
        return responseDTO;
    }

    @Logable
    @ResponseBody
    @PostMapping("/addCombo")
    public ResponseDTO addCombo(@RequestBody PhyCombo vo){
        ResponseDTO responseDTO = service.addCombo(vo);
        return responseDTO;
    }


    @Logable
    @ResponseBody
    @PostMapping("/editCombo")
    public ResponseDTO editCombo(@RequestBody PhyCombo vo){
        ResponseDTO responseDTO = service.editCombo(vo);
        return responseDTO;
    }

    @Logable
    @ResponseBody
    @PostMapping("/switchComboStatus")
    public ResponseDTO switchComboStatus(@RequestBody PhyCombo vo){
        ResponseDTO responseDTO = service.switchComboStatus(vo);
        return responseDTO;
    }

    @ResponseBody
    @PostMapping("/getAllComboNoPage")
    public ResponseDTO getAllComboNoPage(){
        ResponseDTO responseDTO = service.getAllComboNoPage();
        return responseDTO;
    }

    @ResponseBody
    @PostMapping("/getAllComboWithStatus")
    public ResponseDTO getAllComboWithStatus(@RequestBody PhyCombo vo){
        ResponseDTO responseDTO = service.getAllComboWithStatus(vo.getComboStatus());
        return responseDTO;
    }

}
