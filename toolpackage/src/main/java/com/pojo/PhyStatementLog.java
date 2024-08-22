package com.pojo;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class PhyStatementLog {

  private long statementLogId;
  private long patientId;
  private BigDecimal statementLogNum;
  private java.sql.Timestamp statementLogTime;




}
