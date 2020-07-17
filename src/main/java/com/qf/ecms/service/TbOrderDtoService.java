package com.qf.ecms.service;

import com.qf.ecms.domain.dto.TbOrderDto;

import java.util.List;

public interface TbOrderDtoService {
    //查询全部订单
    List<TbOrderDto> queryAll();
}
