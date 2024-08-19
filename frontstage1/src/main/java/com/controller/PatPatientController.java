package com.controller;

import com.pojo.PhyOrder;
import com.pojo.PhyPatient;
import com.service.PatientService;
import com.util.Md5;
import com.util.ResponseDTO;
import com.vo.LoginVo;
import com.vo.PageVo;
import com.vo.RegisterVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * @author 李璟瑜
 * @date 2024/8/16 14:55
 * @description:
 */
@Controller
@RequestMapping("/patient1")
public class PatPatientController {

    @Autowired
    PatientService service;

    @ResponseBody
    @RequestMapping("/patientLogin")
    public ResponseDTO patientLogin(@RequestBody LoginVo vo){
        ResponseDTO responseDTO = service.patientLogin(vo);
        return responseDTO;
    }

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
    @RequestMapping("/updatePatient")
    public ResponseDTO updatePatient(@RequestBody PhyPatient patient){
        ResponseDTO responseDTO = service.updatePatient(patient);
        return responseDTO;
    }

    @ResponseBody
    @RequestMapping("/getOrderListByIdInPage")
    public ResponseDTO getOrderListByIdInPage(@RequestBody PageVo vo){
        ResponseDTO responseDTO = service.getOrderListByIdInPage(vo);
        return responseDTO;
    }

    @ResponseBody
    @RequestMapping("/checkOutOrder")
    public ResponseDTO checkOutOrder(@RequestBody PhyOrder vo){
        ResponseDTO responseDTO = service.checkOutOrder(vo);
        return responseDTO;
    }

    @ResponseBody
    @RequestMapping("/getOrderIndex")
    public ResponseDTO getOrderIndex(@RequestBody PhyOrder vo){
        return service.getOrderIndex(vo);
    }

    @ResponseBody
    @RequestMapping("/getOrderConclution")
    public ResponseDTO getOrderConclution(@RequestBody PhyOrder vo){
        return service.getOrderConclution(vo);
    }

    @ResponseBody
    @RequestMapping("/getNewInfo")
    public ResponseDTO getNewInfo(@RequestBody PhyPatient vo){
        ResponseDTO newInfo = service.getNewInfo(vo);
        return ResponseDTO.success(newInfo);
    }

}
