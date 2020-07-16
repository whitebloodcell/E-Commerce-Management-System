package com.qf.ecms.mapper;

import com.qf.ecms.domain.entity.ShopCart;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ReceptionShopCartMapper {

    int deleteShopCat( @Param("shopCarts") List<ShopCart> shopCarts);

}