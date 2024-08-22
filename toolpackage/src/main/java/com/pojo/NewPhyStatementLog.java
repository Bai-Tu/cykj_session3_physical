package com.pojo;

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author 李璟瑜
 * @date 2024/8/22 10:11
 * @description:
 */
@Data
public class NewPhyStatementLog {
    private long statementLogId;
    private String patientName;
    private BigDecimal statementLogNum;
    private java.sql.Timestamp statementLogTime;
}
