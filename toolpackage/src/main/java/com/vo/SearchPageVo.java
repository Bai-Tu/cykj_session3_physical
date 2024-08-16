package com.vo;

import lombok.Data;

/**
 * @author 李璟瑜
 * @date 2024/8/8 16:39
 * @description:
 */
@Data
public class SearchPageVo {
    private int pagen;
    private int limit;
    private String name;
    private float lowPrice;
    private float highPrice;
    private String tele;
    private String iden;
}
