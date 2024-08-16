package com.vo;

import lombok.Data;

/**
 * @author 李璟瑜
 * @date 2024/8/16 16:34
 * @description:
 */
@Data
public class ChangePwdVo {
    private int id;
    private String oldPwd;
    private String newPwd;
}
