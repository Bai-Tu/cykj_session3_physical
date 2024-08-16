package com.pojo;

import lombok.Data;

/**
 * @author 李璟瑜
 * @date 2024/8/8 15:20
 * @description:
 */
@Data
public class PhyDepartment {
    /**
     * 部门id
     */
    private Integer departmentId;

    /**
     * 部门名
     */
    private String departmentName;

    /**
     * 部门状态1开启，0软删除
     */
    private Integer departmentStatus;
}