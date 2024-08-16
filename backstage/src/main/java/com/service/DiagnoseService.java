package com.service;

import com.pojo.PhyOrder;
import com.pojo.PhySubitemConclution;
import com.util.ResponseDTO;
import com.vo.PageVo;
import com.vo.SearchPageVo;

/**
 * @author 李璟瑜
 * @date 2024/8/15 10:08
 * @description:
 */
public interface DiagnoseService {
    ResponseDTO getOrderContextByNumberByPage(SearchPageVo vo);
    ResponseDTO updateConclution(PhySubitemConclution vo);
}
