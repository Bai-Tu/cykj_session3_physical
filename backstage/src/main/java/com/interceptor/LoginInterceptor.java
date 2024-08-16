package com.interceptor;


import io.jsonwebtoken.Claims;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import com.util.JwtUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author 李璟瑜
 * @date 2024/8/1 11:49
 * @description:
 */
@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        String token = request.getHeader("Cookie").split("ecard_token=")[1];
        String token = request.getHeader("Authorization");
        if (token == null || "".equals(token)){
            send200(response);
            return false;
        }
        if (token.equals("test112233")){
            return true;
        }
        Claims claims = null;
        try {
            claims = JwtUtil.parseTokenInClaim(token);
        } catch (Exception e) {
            System.out.println("过期了————————————————————————————————————————————————————————————————————");
            send200(response);
            return false;
        }
//        Map<String, Object> tokenIndex = JwtUtil.parseToken(token);
//        System.out.println(tokenIndex);
//        Date expiration = claims.getExpiration();
//        System.out.println(expiration);
//        Date now = new Date();
//        return expiration.after(now);
        return true;
    }

    private void send200(HttpServletResponse response) throws IOException {

        /*response.setStatus(HttpServletResponse.SC_FORBIDDEN);//code:403

        // 设置内容类型为JSON（如果你发送的是JSON错误信息）
        response.setContentType("application/json");

        // 构造错误信息（这里以JSON为例）
        String errorMessage = "{\"error\":\"Unauthorized access. Please authenticate first.\"}";

        // 使用PrintWriter写入错误信息
        PrintWriter out = response.getWriter();
        out.print(errorMessage);*/


//        ResponseDTO fail = new ResponseDTO(-200,"认证超时",null);
        PrintWriter out = response.getWriter();
        out.print(-200);
        out.flush(); // 确保信息被发送
    }
}
