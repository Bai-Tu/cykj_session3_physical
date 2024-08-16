package com.service;

import com.util.ResponseDTO;

/**
 * @author 李璟瑜
 * @date 2024/8/12 20:40
 * @description:
 */
public interface ComboProjectService {
    ResponseDTO getProjectByComboId(int comboId);
    ResponseDTO getSubitemByComboId(int comboId);
}
