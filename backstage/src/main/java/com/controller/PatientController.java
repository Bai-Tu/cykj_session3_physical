package com.controller;

import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import com.pojo.PhyPatient;
import com.service.PatientService;
import com.util.CheckCode;
import com.util.ImageCodeUtils;
import com.util.Md5;
import com.util.ResponseDTO;
import com.vo.LoginVo;
import com.vo.PageVo;
import com.vo.RegisterVo;
import com.vo.SearchPageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 李璟瑜
 * @date 2024/8/7 16:24
 * @description:
 */
@Controller
@CrossOrigin
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    PatientService service;

    @ResponseBody
    @RequestMapping("/registerPatient")
    public ResponseDTO registerPatient(@RequestBody RegisterVo vo, HttpSession session){
        if (vo.getCode().equals(session.getAttribute("code"))){
            String encrypted = Md5.getEncrypted(vo.getPwd());
            vo.setPwd(encrypted);
            return service.registerPatient(vo);
        }else {
            return new ResponseDTO(-2, "验证码错误", null);
        }
    }

    @ResponseBody
    @RequestMapping("/loginPatient")
    public ResponseDTO loginPatient(@RequestBody LoginVo vo) {
        String encrypted = Md5.getEncrypted(vo.getPwd());
        vo.setPwd(encrypted);
        ResponseDTO responseDTO = service.loginPatient(vo);
        return responseDTO;
    }

    @ResponseBody
    @RequestMapping("/getAllPatientByPage")
    public ResponseDTO getAllPatientByPage(@RequestBody PageVo vo){
        ResponseDTO responseDTO = service.getAllPatientByPage(vo);
        return responseDTO;
    }

    @ResponseBody
    @RequestMapping("/editPatient")
    public ResponseDTO editPatient(@RequestBody PhyPatient vo){
        ResponseDTO responseDTO = service.editPatient(vo);
        return responseDTO;
    }

    @ResponseBody
    @RequestMapping("/resetPwd")
    public ResponseDTO resetPwd(@RequestBody PhyPatient vo){
        vo.setPatientPassword("e10adc3949ba59abbe56e057f20f883e");
        ResponseDTO responseDTO = service.editPatient(vo);
        return responseDTO;
    }

    @ResponseBody
    @RequestMapping("/addPatient")
    public ResponseDTO addPatient(@RequestBody PhyPatient vo){
        ResponseDTO responseDTO = service.addPatient(vo);
        return responseDTO;
    }

    @ResponseBody
    @RequestMapping("/addBudget")
    public ResponseDTO addBudget(@RequestBody PhyPatient vo){
        ResponseDTO responseDTO = service.addBudget(vo);
        return responseDTO;
    }

    @ResponseBody
    @RequestMapping("/searchPatient")
    public ResponseDTO searchPatient(@RequestBody SearchPageVo vo){
        ResponseDTO responseDTO = service.searchPatient(vo);
        return responseDTO;
    }

    @ResponseBody
    @RequestMapping("/uploadExcel")
    public ResponseDTO uploadExcel(@RequestParam("file") MultipartFile file){
        try{
            List<String> failNames = new ArrayList<>();
            InputStream inputStream = file.getInputStream();
            ExcelReader reader = ExcelUtil.getReader(inputStream);

            List<Map<String, Object>> maps = reader.readAll();
            for (Map<String, Object> row : maps) {
                if (row.get("patientName").equals("用户昵称")){
                    continue;
                }
                PhyPatient patient = new PhyPatient();

                patient.setPatientName(String.valueOf(row.get("patientName")));
                patient.setPatientPhone(String.valueOf(row.get("patientPhone")));
                patient.setPatientIdentity(String.valueOf(row.get("patientIdentity")));
                patient.setPatientAge(String.valueOf(row.get("patientAge")));

                System.out.println(row);
                ResponseDTO responseDTO = service.addPatient(patient);
                if (responseDTO.getCode() == -2){
                    failNames.add(patient.getPatientName());
                }

            }
            reader.close();
            return ResponseDTO.success(failNames);

        } catch(Exception e){
            e.printStackTrace();
            System.out.println(e.getMessage());
            return ResponseDTO.fail(e.getMessage());
        }
    }

}
