package com.qf.ecms.controller;

import com.qf.ecms.domain.entity.ShopCart;
import com.qf.ecms.exception.ServiceException;
import com.qf.ecms.service.ShopCartService;
import com.qf.ecms.utils.ErrorStatus;
import com.qf.ecms.utils.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

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

    /**
     * 购物车列表请求方法
     * @param userId 用户id
     * @return 购物车对象集合
     */
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

    /**
     * 删除购物车请求方法
     * @param map 购物车id集合
     * @return
     */
    @PostMapping("/delete")
    public ResponseEntity<Integer> deleteShopCarts(@RequestBody Map<String,List<Integer>> map) {
        ResponseEntity<Integer> responseEntity = new ResponseEntity<>();
        List<Integer> cartIds = map.get("cartIds");
        try {
            int row = shopCartService.deleteShopCart(cartIds);
            if (row > 0) {
                return responseEntity.success(row);
            } else {
                responseEntity = responseEntity.error(ErrorStatus.DELETE_ERROR);
            }
        } catch (Exception e) {
            responseEntity = ResponseEntity.error();
        }
        return responseEntity;
    }
}
