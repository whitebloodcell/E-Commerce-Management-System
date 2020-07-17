package com.qf.ecms.mapper;

import com.qf.ecms.domain.entity.TbOrder;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TbOrderMapper {
    int deleteByPrimaryKey(Integer orderId);

    int insert(TbOrder record);

    int insertSelective(TbOrder record);

    TbOrder selectByPrimaryKey(Integer orderId);

    int updateByPrimaryKeySelective(TbOrder record);

    int updateByPrimaryKey(TbOrder record);


    //单个订单的删除,逻辑删除
    int tbOrderDelete(@Param("orderNo") String orderNo);
    //批量删除
    int tbOrderDeleteBatch(@Param("list") List<String> list);
    //根据订单号 修改订单的发货状态
    int tbOrderUpdateStatus(@Param("orderOn") String orderNo,@Param("status") int status);
}