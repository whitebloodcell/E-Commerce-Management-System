package com.qf.ecms.service.impl;

import com.qf.ecms.domain.dto.ReceptionOrderDto;
import com.qf.ecms.domain.entity.ColorSize;
import com.qf.ecms.domain.entity.Order;
import com.qf.ecms.domain.entity.OrderItem;
import com.qf.ecms.domain.entity.ShopCart;
import com.qf.ecms.exception.DaoException;
import com.qf.ecms.mapper.ReceptionColorSizeMapper;
import com.qf.ecms.mapper.ReceptionOrderItemMapper;
import com.qf.ecms.mapper.ReceptionOrderMapper;
import com.qf.ecms.mapper.ReceptionShopCartMapper;
import com.qf.ecms.service.ReceptionOrderService;
import com.qf.ecms.utils.ErrorStatus;
import com.qf.ecms.utils.GenerateCodeUtil;
import com.sun.org.apache.xpath.internal.operations.Or;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class ReceptionOrderServiceImpl implements ReceptionOrderService {


    @Resource
    ReceptionOrderMapper receptionOrderMapper;

    @Resource
    ReceptionOrderItemMapper receptionOrderItemMapper;

    @Resource
    ReceptionShopCartMapper receptionShopCartMapper;

    @Resource
    ReceptionColorSizeMapper receptionColorSizeMapper;





    @Override
    @Transactional
    public int addOrder(ReceptionOrderDto receptionOrderDto) {
        //订单对象
        Order order = receptionOrderDto.getOrder();
        //用户id
        int userId = order.getUserId();
        //购物车商品
        List<ShopCart> shopCarts = receptionOrderDto.getShopCarts();
        //随机生成的订单号
        GenerateCodeUtil generateCodeUtil = new GenerateCodeUtil();
        String orderNo =  generateCodeUtil.createCodeNum("No");
        order.setOrderNo(orderNo);

        List<OrderItem>  orderItems = new ArrayList<OrderItem>();
        /*
        *
        * 计算总价
        * 循环遍历添加购物车商品
        * 总价=单价*数量
        * 事务判断添加订单是否成功,不成功就报异常回滚
        * */
        BigDecimal total = new BigDecimal(0.00);
        for (ShopCart shopCart : shopCarts) {
            //单价
            BigDecimal price = shopCart.getPresentPrice();
            //数量
            int count = shopCart.getCount();
            total = total.add(price.multiply(BigDecimal.valueOf(count)));
        }
        order.setTotal(total);//总价
        //添加订单
        int addOrder =receptionOrderMapper.addOrder(order);
        //事务判断添加订单是否成功,不成功就报异常回滚
        if (addOrder==0){
            throw new DaoException(ErrorStatus.DAO_ERROR);
        }

        //添加商品详情
        for (ShopCart shopCart:shopCarts){
            OrderItem orderItem = new OrderItem();
            orderItem.setOrderId(order.getOrderId());
            orderItem.setUserId(userId);
            orderItem.setCommodityPic(shopCart.getCommentPicture());
            orderItem.setCommodityTitle(shopCart.getCommodityTitle());
            orderItem.setCommodityPrice(shopCart.getPresentPrice());
            orderItem.setCommodityQuantity(shopCart.getCount());
            orderItem.setColorName(shopCart.getColorName());
            orderItem.setSizeName(shopCart.getSizeName());
            orderItem.setCid(shopCart.getCid());
            orderItems.add(orderItem);
            /*
             *
             * 减已添加到购物车中的商品的库存
             *  csid
             * */
            ColorSize colorSize = receptionColorSizeMapper.selectByCsId(shopCart.getCsid());
            //判断数量是否大于库存,大于直接回滚
            int count = shopCart.getCount();
            if (count > colorSize.getStock()){
                throw new DaoException("库存不够", 2000);
            }

            int stock = colorSize.getStock() - count;
            int updateStock = receptionColorSizeMapper.updateToStock(shopCart.getCsid(),stock,colorSize.getVersion());
            if (updateStock==0){
                throw new DaoException(ErrorStatus.DAO_ERROR);
            }
        }

        //添加订单详情
        int addOrderItem = receptionOrderItemMapper.addOrderItem(orderItems);
        //事务判断添加订单详情是否成功,不成功就报异常回滚
        if (addOrderItem!=shopCarts.size()){
            throw new DaoException(ErrorStatus.DAO_ERROR);
        }

        //删除购物车中以添加到订单中的商品
        int delToShopCart = receptionShopCartMapper.deleteShopCat(shopCarts);
        if (delToShopCart!=shopCarts.size()){
            throw new DaoException(ErrorStatus.DAO_ERROR);
        }

        return 1;
    }
}
