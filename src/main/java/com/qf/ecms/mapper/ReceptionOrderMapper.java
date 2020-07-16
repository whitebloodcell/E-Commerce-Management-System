package com.qf.ecms.mapper;
import com.qf.ecms.domain.entity.Order;
import org.apache.ibatis.annotations.Param;

public interface ReceptionOrderMapper {

    int addOrder(@Param("order") Order order);


}