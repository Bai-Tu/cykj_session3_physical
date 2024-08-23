package com.controller;

import com.service.StatementLogService;
import com.util.ResponseDTO;
import com.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 李璟瑜
 * @date 2024/8/22 9:58
 * @description:
 */
@Controller
@RequestMapping("/statementlog")
public class StatementlogController {

    @Autowired
    StatementLogService service;

    @ResponseBody
    @PostMapping("/getStatementlogByPage")
    public ResponseDTO getStatementlogByPage(@RequestBody PageVo vo){
        ResponseDTO responseDTO = service.getStatementlogByPage(vo);
        return responseDTO;
    }

    @ResponseBody
    @PostMapping("/getStatementlogInSearchByPage")
    public ResponseDTO getStatementlogInSearchByPage(@RequestBody PageVo vo){
        ResponseDTO responseDTO = service.getStatementlogInSearchByPage(vo);
        return responseDTO;
    }

}
