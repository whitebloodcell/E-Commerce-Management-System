package com.qf.ecms.mapper;

import com.qf.ecms.domain.entity.ShopCart;import com.qf.ecms.exception.DaoException;import org.apache.ibatis.annotations.Param;

public interface ShopCartMapper {
    int deleteByPrimaryKey(Integer cartId);

    int insert(ShopCart record);

    int insertSelective(ShopCart record);

    ShopCart selectByPrimaryKey(Integer cartId);

    int updateByPrimaryKeySelective(ShopCart record);

    int updateByPrimaryKey(ShopCart record);

    /**
     * 插入购物车记录
     *
     * @param shopCart
     * @return
     */
    int insertShopCart(@Param("shopCart") ShopCart shopCart) throws DaoException;

    /**
     * 根据颜色尺寸表主键和用户ID查询购物车记录
     *
     * @param csid   颜色尺寸表主键
     * @param userId 用户表主键
     * @return
     */
    ShopCart selectShopCartByCsIdAndUserId(@Param("csid") int csid, @Param("userId") int userId);

    /**
     * 根据购物车主键修改购物车购买数量
     *
     * @param cartId
     * @param count
     * @return 修改成功数量
     */
    int updateShopCartCount(@Param("cartId") int cartId, @Param("count") int count);
}