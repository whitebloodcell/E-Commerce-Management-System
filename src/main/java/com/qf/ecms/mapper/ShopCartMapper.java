package com.qf.ecms.mapper;

import com.qf.ecms.domain.entity.ShopCart;

public interface ShopCartMapper {
    int deleteByPrimaryKey(Integer cartId);

    int insert(ShopCart record);

    int insertSelective(ShopCart record);

    ShopCart selectByPrimaryKey(Integer cartId);

    int updateByPrimaryKeySelective(ShopCart record);

    int updateByPrimaryKey(ShopCart record);
}