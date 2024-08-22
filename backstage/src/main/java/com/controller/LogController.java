package com.controller;

import com.service.LogsService;
import com.util.ResponseDTO;
import com.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 李璟瑜
 * @date 2024/8/22 14:49
 * @description:
 */
@Controller
@RequestMapping("/logs")
public class LogController {
    @Autowired
    LogsService service;

    @ResponseBody
    @RequestMapping("/getLogsByPage")
    public ResponseDTO getLogsByPage(@RequestBody PageVo vo){
        ResponseDTO responseDTO = service.getLogsByPage(vo);
        return responseDTO;
    }

}
