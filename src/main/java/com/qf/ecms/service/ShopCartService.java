package com.qf.ecms.service;


import com.qf.ecms.domain.entity.ShopCart;
import com.qf.ecms.exception.ServiceException;

import java.util.List;

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

    /**
     * 查看所有购物车信息
     * @param userId
     * @return 购物车列表
     */
    List<ShopCart> findAllCarts (int userId);
}
