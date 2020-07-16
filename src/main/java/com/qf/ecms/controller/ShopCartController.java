package com.qf.ecms.controller;

import com.qf.ecms.domain.entity.ShopCart;
import com.qf.ecms.exception.ServiceException;
import com.qf.ecms.service.ShopCartService;
import com.qf.ecms.utils.ErrorStatus;
import com.qf.ecms.utils.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * 购物车控制层
 */
@RestController
@RequestMapping("/shopcart")
public class ShopCartController {
    @Resource
    ShopCartService shopCartService;

    @PostMapping("/add")
    public ResponseEntity<Integer> AddShopCart(@RequestBody ShopCart shopCart) {
        ResponseEntity<Integer> responseEntity = new ResponseEntity<>();
        try {
            int row = shopCartService.addShopCar(shopCart);
            if (row > 0) {
                responseEntity = responseEntity.success(row);
            } else {
                responseEntity = responseEntity.error();
            }
        } catch (ServiceException e) {
            return ResponseEntity.error(e.getStatus(), e.getMsg());
        } catch (Exception e) {
            responseEntity = ResponseEntity.error();
        }
        return responseEntity;
    }

    /**
     * 修改购物车商品数量
     *
     * @param shopCart 购物车对象
     * @return
     */
    @PostMapping("/updateCount")
    public ResponseEntity<Integer> updateCount(@RequestBody ShopCart shopCart) {
        ResponseEntity<Integer> responseEntity = new ResponseEntity<>();
        try {
            int row = shopCartService.updateShopCartCount(shopCart);
            if (row > 0) {
                return responseEntity.success(row);
            } else {
                responseEntity = responseEntity.error();
            }
        } catch (ServiceException e) {
            return ResponseEntity.error(e.getStatus(), e.getMsg());
        } catch (Exception e) {
            responseEntity = ResponseEntity.error();
        }
        return responseEntity;
    }

    @GetMapping("/list")
    public ResponseEntity<List<ShopCart>> shopCartList (@RequestParam int userId){
        ResponseEntity<List<ShopCart>> responseEntity = new ResponseEntity<>();
        try{
            List<ShopCart> cartList = shopCartService.findAllCarts(userId);
            if(cartList.size()>0){
                responseEntity=responseEntity.success(cartList);
            }else {
                responseEntity=responseEntity.error(ErrorStatus.DATA_ERROR);
            }
        }catch (Exception e){
            responseEntity = ResponseEntity.error();
        }
        return responseEntity;
    }
}
