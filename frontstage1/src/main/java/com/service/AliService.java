package com.service;

import com.ali.AlipayBean;
import com.alipay.api.AlipayApiException;

/**
 * @author 李璟瑜
 * @date 2024/8/19 9:07
 * @description:
 */
public interface AliService {
    /**
     * 支付宝支付接口
     * @param alipayBean
     * @return
     * @throws AlipayApiException
     */
    String aliPay(AlipayBean alipayBean) throws AlipayApiException;
}
