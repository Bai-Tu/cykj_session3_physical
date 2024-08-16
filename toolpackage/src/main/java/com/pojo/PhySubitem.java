package com.pojo;


import lombok.Data;

@Data
public class PhySubitem {
  /**
   * id
   */
  private Integer subitemId;

  /**
   * 名字
   */
  private String subitemName;

  /**
   * 标准值最小
   */
  private String subitemStandardMin;

  /**
   * 标准值最大
   */
  private String subitemStandardMax;

  /**
   * 单位
   */
  private String subitemUnit;

  /**
   * 状态  1开启 0隐藏
   */
  private Integer subitemStatus;

}
