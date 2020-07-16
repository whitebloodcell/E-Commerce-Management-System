package com.qf.ecms.controller;

import com.qf.ecms.domain.entity.ShopCart;
import com.qf.ecms.service.ShopCartService;
import com.qf.ecms.utils.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

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
        try{
            int row = shopCartService.addShopCar(shopCart);
            if(row>0){
                responseEntity = responseEntity.success(row);
            }else {
                responseEntity = responseEntity.error();
            }
        }catch (Exception e){
            responseEntity = ResponseEntity.error();
        }
        return responseEntity;
    }
}
