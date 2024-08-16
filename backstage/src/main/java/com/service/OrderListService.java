package com.service;

import com.pojo.PhyOrder;
import com.util.ResponseDTO;
import com.vo.OrderVo;
import com.vo.PageVo;
import com.vo.SearchPageVo;

/**
 * @author 李璟瑜
 * @date 2024/8/14 9:11
 * @description:
 */
public interface OrderListService {
    ResponseDTO getOrderListByIdInPage(PageVo vo);
    ResponseDTO searchOrderByIdInPage(SearchPageVo vo);
    ResponseDTO checkOutOrder(PhyOrder vo);
    ResponseDTO addOrder(OrderVo vo);
}
