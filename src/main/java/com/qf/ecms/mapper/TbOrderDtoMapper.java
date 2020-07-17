package com.qf.ecms.mapper;

import com.qf.ecms.domain.dto.TbOrderDto;

import java.util.List;

public interface TbOrderDtoMapper {
    //查询全部订单
    List<TbOrderDto> selectAll();
}
