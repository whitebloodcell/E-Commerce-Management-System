package com.qf.ecms.service.impl;

import com.qf.ecms.domain.entity.ShopCart;
import com.qf.ecms.exception.ServiceException;
import com.qf.ecms.mapper.ColorSizeMapper;
import com.qf.ecms.mapper.ShopCartMapper;
import com.qf.ecms.service.ShopCartService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * 购物车业务层
 */
@Service
public class ShopCartServiceImpl implements ShopCartService {
    @Resource
    ShopCartMapper shopCartMapper;
    @Resource
    ColorSizeMapper colorSizeMapper;

    /**
     * 添加购物车
     *
     * 1.查看当前商品颜色尺寸的库存
     * 2.查看当前购物车记录
     * 3.如果没有这条购物车记录则添加购物车
     * 4.有记录则修改购物车数量和总价
     * @param shopCart
     * @return
     */
    @Override
    @Transactional
    public int addShopCar(ShopCart shopCart) throws ServiceException {
        int stock = colorSizeMapper.SelectStockByCsid(shopCart.getCsid());
        int row = 0;
        if(stock>=shopCart.getCount()){
            //查询当前商品的购物车记录
            ShopCart sc = shopCartMapper.selectShopCartByCsIdAndUserId(shopCart.getCsid(), shopCart.getUserId());
            //对象不为空则表示有记录,修改购物车数量为添加数量,否则添加购物车记录
            if(sc!=null){
                //要添加的商品数量
                int addCount = shopCart.getCount();
                //要修改的商品数量 = 要添加的商品数量+已存在购物车的数量
                int newCount = addCount+sc.getCount();
                row = shopCartMapper.updateShopCartCount(sc.getCartId(),newCount);
            }else {
                row = shopCartMapper.insertShopCart(shopCart);
            }
        }else {
            throw new ServiceException("当前购买数量大于库存",20000);
        }
        return row;
    }
}
