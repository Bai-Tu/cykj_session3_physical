package com.controller;


import com.ali.AlipayBean;
import com.ali.AlipayConfig;
import com.alipay.api.AlipayApiException;
import com.alipay.api.internal.util.AlipaySignature;
import com.pojo.PhyPatient;
import com.service.AliService;
import com.service.PatientService;
import com.util.ResponseDTO;
import com.alipay.easysdk.factory.Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 李璟瑜
 * @date 2024/8/19 9:09
 * @description:
 */
@RestController
@RequestMapping("/pay")
@CrossOrigin
public class AliController {
    @Resource
    private AliService payService;
    @Autowired
    private PatientService service;

    /**
     * 阿里支付
     * @param alipayBean
     * @return
     * @throws AlipayApiException
     */
    @PostMapping("/alipay")
    public ResponseDTO alipay(@RequestBody AlipayBean alipayBean) throws AlipayApiException {
        System.out.println(alipayBean);
        long time = new Date().getTime();
        alipayBean.setOut_trade_no(String.valueOf(time));
        Map<String,Object> map = new HashMap<String,Object>();


        String str = payService.aliPay(alipayBean);
        System.out.println(str);
        map.put("msg",str);
        map.put("code",0);
//
        return ResponseDTO.success(map);
    }

    @PostMapping("/getResponse")
    public ResponseDTO getResponse(HttpServletRequest request) throws Exception{
        if (request.getParameter("trade_status").equals("TRADE_SUCCESS")) {
            System.out.println("=========支付宝异步回调========");

            AlipayConfig alipayConfig = new AlipayConfig();
            Map<String,String> params =new HashMap<>();
            Map<String,String[]>requestParams =request.getParameterMap();
            for (String name:requestParams.keySet()){
                params.put(name,request.getParameter(name));
            }
            String sign=params.get("sign");
            String content = AlipaySignature.getSignCheckContentV1(params);
            // 支付宝验签
            if (AlipaySignature.rsa256CheckContent(content,sign,alipayConfig.getPublicKey(),"UTF-8")) {
                // 验签通过
//                System.out.println("交易名称: " + params.get("subject"));
//                System.out.println("交易状态: " + params.get("trade_status"));
//                System.out.println("支付宝交易凭证号: " + params.get("trade_no"));
//                System.out.println("商户订单号: " + params.get("out_trade_no"));
                System.out.println("交易金额: " + params.get("total_amount"));
//                System.out.println("买家在支付宝唯一id: " + params.get("buyer_id"));
//                System.out.println("买家付款时间: " + params.get("gmt_payment"));
//                System.out.println("买家付款金额: " + params.get("buyer_pay_amount"));
                System.out.println("买家id:"+params.get("body"));
                // 更新订单状态
                PhyPatient vo = new PhyPatient();
                vo.setPatientId(Integer.valueOf(params.get("body")));
                vo.setPatientBuddget(BigDecimal.valueOf(Float.parseFloat(params.get("total_amount"))));
                service.addBudget(vo);
                System.out.println("__________________编辑成功——————————————————————————————————");

            }else {
                System.out.println("______验证失败________");
            }
        }
        return ResponseDTO.success();
    }
}
