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

    /**
     * 修改购物车商品数量
     * @param shopCart 购物车对象
     * @return
     */
    int updateShopCartCount (ShopCart shopCart) throws ServiceException;
}
