package com.service;

import com.pojo.PhyConclution;
import com.util.ResponseDTO;

/**
 * @author 李璟瑜
 * @date 2024/8/15 14:16
 * @description:
 */
public interface ConclutionService {
    ResponseDTO getConclutionByOrderNumber(PhyConclution vo);
    ResponseDTO setConclution(PhyConclution vo);
}
