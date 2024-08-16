package com.mapper;

import com.pojo.PhyOrder;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 李璟瑜
 * @date 2024/8/14 9:11
 * @description:
 */
public interface PhyOrderMapper {
    int deleteByPrimaryKey(Integer orderId);

    int insert(PhyOrder record);

    int insertSelective(PhyOrder record);

    PhyOrder selectByPrimaryKey(Integer orderId);

    int updateByPrimaryKeySelective(PhyOrder record);

    int updateByPrimaryKey(PhyOrder record);
    List<PhyOrder> getOrderListByIdInPage(int id);
    List<PhyOrder> searchOrderByIdInPage(@Param("id")int id,@Param("name") String name);
}