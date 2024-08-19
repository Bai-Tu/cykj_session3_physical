package com.service.impl;

import com.ali.Alipay;
import com.ali.AlipayBean;
import com.alipay.api.AlipayApiException;
import com.service.AliService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author 李璟瑜
 * @date 2024/8/19 9:08
 * @description:
 */
@Service
public class AliServiceImpl implements AliService {
    @Resource
    private Alipay alipay;


    @Override
    public String aliPay(AlipayBean alipayBean) throws AlipayApiException {
        return alipay.pay(alipayBean);
    }
}
