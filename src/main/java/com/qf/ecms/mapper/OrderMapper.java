package com.qf.ecms.mapper;

import com.qf.ecms.domain.entity.Order;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderMapper {

    int insert(@Param("order") Order order);    //将加入购物车的商品保存成订单


    int updateByOrderNo(@Param("orderNo") String orderNo,@Param("status") int status);  //根据订单号修改订单是否已发货


    List<Order> selectAll();   //查询所有的订单


    List<Order> selectDelivered(@Param("status") int status);   //查询已发货的订单


    List<Order> selectBack(@Param("status") int status);    //查询已退货的订单


    int deleteOne(@Param("orderNo") String orderNo);      //根据订单号删除订单


    int deleteBatch(List<Order> list);      //批量删除,批量传入订单号,删除订单
}
