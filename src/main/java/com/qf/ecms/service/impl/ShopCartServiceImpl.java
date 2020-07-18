package com.qf.ecms.service.impl;

import com.qf.ecms.domain.entity.ShopCart;
import com.qf.ecms.exception.ServiceException;
import com.qf.ecms.mapper.ColorSizeMapper;
import com.qf.ecms.mapper.ShopCartMapper;
import com.qf.ecms.service.ShopCartService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

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
        //查看当前商品的库存
        int stock = colorSizeMapper.selectStockByCsid(shopCart.getCsid());
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

    /**
     * 1.查看当前商品库存
     * 2.修改数量大于商品库存则返回出错信息
     * 3.否则修改购物车商品数量
     * @param shopCart 购物车对象
     * @return
     */
    @Override
    public int updateShopCartCount(ShopCart shopCart) throws ServiceException {
        //查看当前商品的库存
        int stock = colorSizeMapper.selectStockByCsid(shopCart.getCsid());
        //购物车商品要修改的数量
        int count = shopCart.getCount();
        //修改成功数
        int row = 0;
        if (count<=stock){
            row = shopCartMapper.updateShopCartCount(shopCart.getCartId(), shopCart.getCount());
        }else {
            shopCartMapper.updateShopCartCount(shopCart.getCartId(), count);
            throw new ServiceException("最多只能买"+stock+"件",20000);
        }
        return row;
    }

    /**
     * 查看所有购物车信息
     * @param userId
     * @return 购物车列表
     */
    @Override
    public List<ShopCart> findAllCarts(int userId) throws ServiceException{
        return shopCartMapper.selectAllShopCartByUserId(userId);
    }

    /**
     * 批量删除购物车
     * @param cartIds
     * @return
     */
    @Override
    public int deleteShopCart(List<Integer> cartIds) {
        return shopCartMapper.updateShopCartStatusByShopCartId(cartIds);
    }


}
