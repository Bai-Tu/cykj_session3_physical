package com.controller;

import com.pojo.PhyOrder;
import com.service.OrderListService;
import com.util.RandomOrderNumber;
import com.util.ResponseDTO;
import com.vo.OrderVo;
import com.vo.PageVo;
import com.vo.SearchPageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 李璟瑜
 * @date 2024/8/14 9:08
 * @description:
 */
@Controller
@RequestMapping("/orderList")
public class OrderListController {
    @Autowired
    OrderListService service;


    @ResponseBody
    @RequestMapping("/getOrderListByIdInPage")
    public ResponseDTO getOrderListByIdInPage(@RequestBody PageVo vo){
        ResponseDTO responseDTO = service.getOrderListByIdInPage(vo);
        return responseDTO;
    }

    @ResponseBody
    @RequestMapping("/searchOrderByIdInPage")
    public ResponseDTO searchOrderByIdInPage(@RequestBody SearchPageVo vo){
        ResponseDTO responseDTO = service.searchOrderByIdInPage(vo);
        return responseDTO;
    }

    @ResponseBody
    @RequestMapping("/checkOutOrder")
    public ResponseDTO checkOutOrder(@RequestBody PhyOrder vo){
        ResponseDTO responseDTO = service.checkOutOrder(vo);
        return responseDTO;
    }

    @ResponseBody
    @RequestMapping("/addOrder")
    public ResponseDTO addOrder(@RequestBody OrderVo vo){
        vo.setOrderNumber(RandomOrderNumber.generateOrderNumber());
        ResponseDTO responseDTO = service.addOrder(vo);
        return responseDTO;
    }

}
