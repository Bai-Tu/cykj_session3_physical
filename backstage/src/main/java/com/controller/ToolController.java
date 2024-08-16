package com.controller;

import com.util.ImageCodeUtils;
import com.util.JwtUtil;
import com.util.ResponseDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

/**
 * @author 李璟瑜
 * @date 2024/8/8 13:18
 * @description:
 */
@Controller
@CrossOrigin
@RequestMapping("/tool")
public class ToolController {

    @RequestMapping("/refreshCheckCode")
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
    @RequestMapping("/parseToken")
    public ResponseDTO parseToken(String token){
        Map<String, Object> map = JwtUtil.parseToken(token);
        return ResponseDTO.success(map);
    }
}
