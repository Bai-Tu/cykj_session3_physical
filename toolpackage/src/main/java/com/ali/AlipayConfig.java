package com.ali;

import lombok.Data;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @author 李璟瑜
 * @date 2024/8/19 8:56
 * @description:
 */
@Configuration
@Data
@Component
public class AlipayConfig {
    /**
     * 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
     */
    private String appId = "9021000140611946";

    /**
     * 商户私钥，您的PKCS8格式RSA2私钥
     */
    private String privateKey = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCFqGHV0K+SuM1YkXxf5ZXOXrWehioDl6naeSIzY1PmW1OhAUaYukLio3sEEpDgUYc2RnElT+x9YK8okZCek8NqSmhEz0FRZOCvI2aofBA2BwbrzicaEoptZayeWYR/gjrBTKnipBXTDwJIGOovIxIaG/Xsz+i7dsXn+vJC3AvhPTx6O9Wrqz44rliFb3dGFF8H+tsplSkRg29KTRtFz3r0ezoXbOtIf/yCd/ixwyuV5oCw80hEXKviBH1z7xZjR+l7LI6Z9FC0PWNLLyyBOusOxTCbDU04IEi+l6MRnV4UaJsJjaSqTUotDk7OMFx2qavalHPRM+ugj5GN9OaGVPbDAgMBAAECggEAHEwI4o67DTIo725lyZu+uqFcjEJVVMtgP4vTzNNjqOp+6yBtBNqyXG9GFRelKoi4OqpxO/gO1oCItOsUli4sei1ko+TJLGVSGGJDUrppaDbWpUfRCXkRa5XSFPhYz/IPZGtJsF0S7ctIrWDw+6fOJk7zIv7lhALiZXnAnp0dusLAX12hG1wGUt02g7M5Sb2ilJfs/jATj7vX8XyBMCnoWxA+pEuMp1yatJoTDCXYrcM0ewKbP1o/zGd7c8Zv/Rluic7qkVnEwQ0tm6MGErpiawWPNscNhTDDWpwC7dt1UDAfD2k6r4opnYjfpCXyCDFlXcSWZk8LAjFvCwQEIjtBwQKBgQDPDH8813GRqsacLHKeF/65xd84TyOAPDNiezywzfvi9AAxfTFlsckJsYIkmixXrACdZaI3A0NvYqrNTFBLl7xd/TrrZrPdPpC3c7arn15JhpEdkzk1sfiQExEKtH82oZSfvuOtq532wSeofHd84ESiKK+FxII0ryR3Jg1sdwKJ4wKBgQClQe9wDcBZh4LvFoP6zCHteBWqc+neareLaOVNniC+dAGZIiKPL0IZvi6Ifx3Z9ETwqrQyaRcJtbM/ziM73jWN1KvLrPHZpD6jmQXSH8qjnAUFdpmd7luq9FfLfgtxM5cgoCO3shTWXrMrcFbOULfHH2YGS57aN0g1gFTd5AL1oQKBgD6qzaggnWM1iT+jxF1Nbe/UkCd+7IPXtMXN/ySUc/TRXW2dMuJQ2URx0a46a8ltahI5vMth1XtVJdVVj8gReRYJm1e8khwY37xm7ZcseWFPtYR6FwrFfzI8UyAmWYqzhUSEhmz+UKVq+RHp+lB1oNBj+BxIyhAgIq1dexqlOsN5AoGBAJbibbhUheP4iz66wwPw76U++CEqNkTiEPVTb9F/aAwcJP1pIj6zelnAwAHWdi3zDiLi6SYBt4wg/ylpj9fwmdsGa1jKbgM2KA78/0iLyFu7bwY+9CEzaTTcZXChg9b2sKyUKihliwrzaglmR4uWPUWsUF29G6vHv8FBi7sQnPchAoGBAJhFfrWRdLAWk1Engi2wC+844UFNyxZPl4Ic+pfNVH6KD4BSG5+F9ZXjyP4uU1+apls/Rx439+4w0+IzvfSbfqLs9EUiIhkxnTK67Tj8rdI5xGecbDHuWRTbHkqsa7xi3Q0aMP0Y/q201AoW5kKKzGEaIeMBESc6uxa+yw8Lg0Ps";

    /**
     * 支付宝公钥,
     */
    private String publicKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAsEXec2tzbyWXXYyOnXoLUzQ5QhV//+X/8IDXcOyq07u9dRaP1g8SFAcYcdvmdDiS164Ay89o1svwMW4y6W9uKgBvDQyWwEPXpHNmQ7F7uRQjNBz7AcJOio/kZAdpDDDJDYRGfnVZuyQ4PllVpfReRAyKdvE/jqsor/UA1rTE4TS0R3O2oheZ/SR00X0Js4SCvoJCIbANIwrGbq000V/lZFdiP/iBhHPUa9+y42b8FmcLzeHqxehuqWK0jAC91W3Hge5TE+bIxY2pD9LVDgtAK4v8mKOjn2IfEfYu+CUyhefO8UDFfrDjiwHvuRq/y7naQoYtE54D2+FF1Jw32gy6RQIDAQAB";

    /**
     * 服务器异步通知页面路径需http://格式的完整路径，不能加?id=123这类自定义参数
     */
    private String notifyUrl = "http://9qzgwt.natappfree.cc/pat/pay/getResponse";

    /**
     * 页面跳转同步通知页面路径 需http://格式的完整路径.
     * 支付完成后返回的地址
     */
    private String returnUrl = "http://127.0.0.1:8086/#/patient";

    /**
     * 签名方式
     */
    private String signType = "RSA2";

    /**
     * 字符编码格式
     */
    private String charset = "utf-8";

    /**
     * 支付宝网关
     */
    private String gatewayUrl = "https://openapi-sandbox.dl.alipaydev.com/gateway.do";

    /**
     * 支付宝网关
     */
    private String logPath = "C:\\";
}
