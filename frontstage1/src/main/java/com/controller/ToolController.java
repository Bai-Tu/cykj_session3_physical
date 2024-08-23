package com.controller;

import com.mapper.PatPatientMapper;
import com.pojo.PhyPatient;
import com.util.ImageCodeUtils;
import com.util.JwtUtil;
import com.util.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 李璟瑜
 * @date 2024/8/8 13:18
 * @description:
 */
@Controller
@CrossOrigin
@RequestMapping("/tool1")
public class ToolController {

    @Autowired
    PatPatientMapper mapper;

    @PostMapping("/refreshCheckCode")
    public void refreshCheckCode(HttpServletResponse response, HttpSession session){
        ImageCodeUtils imageCodeUtils = new ImageCodeUtils();
        System.out.println("进来了"+imageCodeUtils);
        session.setAttribute("code",imageCodeUtils.getCode());
        try {
            imageCodeUtils.write(response.getOutputStream());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @ResponseBody
    @PostMapping("/parseToken")
    public ResponseDTO parseToken(String token){
        Map<String, Object> map = JwtUtil.parseToken(token);
        Map<String,Object> adminInfo = (Map<String, Object>)map.get("adminInfo");
        PhyPatient patient = mapper.selectByPrimaryKey(Integer.valueOf(adminInfo.get("patientId").toString()));
        return ResponseDTO.success(patient);
    }




}
