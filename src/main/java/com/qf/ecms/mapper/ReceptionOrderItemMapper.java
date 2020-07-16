package com.qf.ecms.mapper;

import com.qf.ecms.domain.entity.OrderItem;
import org.apache.ibatis.annotations.Param;
import java.util.List;

public interface ReceptionOrderItemMapper {
    int addOrderItem(@Param("orderItems")List<OrderItem> orderItems);
}