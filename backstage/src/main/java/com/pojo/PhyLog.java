package com.pojo;

import java.util.Date;
import lombok.Data;

/**
 * @author 李璟瑜
 * @date 2024/8/8 10:57
 * @description:
 */
@Data
public class PhyLog {
    /**
    * 日志id
    */
    private Integer logId;

    /**
    * 管理员id
    */
    private Integer adminId;

    /**
    * 日志内容
    */
    private String logs;

    /**
    * 日志创建时间
    */
    private Date logTime;
}