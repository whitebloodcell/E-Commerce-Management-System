package com.qf.ecms.service;


import com.qf.ecms.domain.entity.ShopCart;
import com.qf.ecms.exception.ServiceException;

public interface ShopCartService {

    /**
     * 添加购物车
     * @param shopCart
     * @return
     */
    int addShopCar (ShopCart shopCart) throws ServiceException;
}
