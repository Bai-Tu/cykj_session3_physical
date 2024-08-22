package com.aspect;


import com.alibaba.fastjson2.JSONObject;
import com.mapper.PhyLogMapper;
import com.pojo.PhyLog;
import com.service.LogsService;
import com.util.JwtUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.Map;

@Aspect
@Component
public class LoggingAspect {

    private HttpServletRequest request;


    private PhyLogMapper logMapper;


    @Autowired
    public LoggingAspect(HttpServletRequest request, PhyLogMapper logMapper) {
        this.request = request;
        this.logMapper = logMapper;
    }

    @Pointcut("@annotation(com.annotation.Logable)")
    public void loggableMethods() {
    }


//    @After("execution(* com.controller..*.*(..))")
    @After("loggableMethods()")
    public void logAfter(JoinPoint joinPoint){
        String token = request.getHeader("Authorization");
        if (token == null){
            return;
        }
        Map<String, Object> stringObjectMap = JwtUtil.parseToken(token);
        Map<String,Object> adminInfo = (Map<String, Object>)stringObjectMap.get("adminInfo");
        Integer id = Integer.valueOf(adminInfo.get("adminId").toString());

        String active_name = joinPoint.getSignature().getName();


        PhyLog logs = new PhyLog();
        logs.setAdminId(id);
        logs.setLogs(active_name);
        logMapper.insertSelective(logs);
    }
}
