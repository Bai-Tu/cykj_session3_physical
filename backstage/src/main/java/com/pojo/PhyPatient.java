package com.pojo;

import java.math.BigDecimal;
import java.util.Date;

import cn.hutool.core.annotation.Alias;
import lombok.Data;

/**
 * @author 李璟瑜
 * @date 2024/8/13 11:26
 * @description:
 */
@Data
public class PhyPatient {
    /**
     * id
     */
    private Integer patientId;

    /**
     * 名字
     */
    @Alias("用户昵称")
    private String patientName;

    /**
     * 密码
     */
    private String patientPassword;

    /**
     * 余额
     */
    private BigDecimal patientBuddget;

    /**
     * 电话
     */
    @Alias("用户电话")
    private String patientPhone;

    /**
     * 身份证
     */
    @Alias("用户身份证")
    private String patientIdentity;

    /**
     * 年龄
     */
    @Alias("用户年龄")
    private String patientAge;

    /**
     * 注册时间
     */
    private Date patientCreateTime;

    /**
     * 1开启0冻结
     */
    private Integer patientStatus;
}