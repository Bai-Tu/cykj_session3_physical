package com.pojo;

import lombok.Data;

/**
 * @author 李璟瑜
 * @date 2024/8/8 10:57
 * @description:
 */
@Data
public class PhyAdmin {
    /**
     * id
     */
    private Integer adminId;

    /**
     * 管理员名
     */
    private String adminName;

    /**
     * 管理员账户
     */
    private String adminAccount;

    /**
     * 管理员密码
     */
    private String adminPassword;

    /**
     * 管理员身份
     */
    private Integer adminRoleId;

    /**
     * 管理员部门
     */
    private Integer adminDepartmentId;

    /**
     * 管理员状态1启用，0禁用
     */
    private Integer adminStatus;
}