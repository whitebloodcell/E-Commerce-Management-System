package com.qf.ecms.controller;

import com.qf.ecms.domain.entity.UserAddress;
import com.qf.ecms.service.UserAddressService;
import com.qf.ecms.utils.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RequestMapping("/address")
@RestController
public class UserAddressController {
@Resource
    UserAddressService userAddressService;

    @PostMapping("/add")
    public ResponseEntity addAddress (@RequestBody UserAddress userAddress){
        ResponseEntity<Integer> responseEntity = new ResponseEntity<>();
        try{
            //获得添加成功条数,大于0则响应成功给前端,否则返回出错
            int row = userAddressService.addAddress(userAddress);
            if(row>0){
                responseEntity = responseEntity.success(row);
            }else {
                responseEntity = responseEntity.error();
            }
        }catch (Exception e){
            responseEntity = responseEntity.error();
        }
        return responseEntity;
    }

    @PostMapping ("/list")
    public ResponseEntity<List<UserAddress>> findAllAddress(Integer userId){
        ResponseEntity<List<UserAddress>> responseEntity = new ResponseEntity<>();
        try{
            //获得添加成功条数,大于0则响应成功给前端,否则返回出错
            List<UserAddress> addressList = userAddressService.findAllAddress(userId);
            if(addressList.size()>0){
                responseEntity = responseEntity.success(addressList);
            }else {
                responseEntity = responseEntity.error();
            }
        }catch (Exception e){
            responseEntity = ResponseEntity.error();
        }
        return responseEntity;
    }

    @PostMapping ("/update")
    public ResponseEntity<Integer> updateAddress(@RequestBody UserAddress userAddress){
        ResponseEntity<Integer> responseEntity = new ResponseEntity<>();
        try{
            int row = userAddressService.updateUserAddress(userAddress);
            if(row>0){
                responseEntity = responseEntity.success(row);
            }else {
                responseEntity = responseEntity.error();
            }
        }catch (Exception e){
            responseEntity = responseEntity.error();
        }
        return responseEntity;
    }

    @PostMapping("/delete")
    public ResponseEntity<Integer> deleteAddress(int addressId){
        ResponseEntity<Integer> responseEntity = new ResponseEntity<>();
        try{
            int row = userAddressService.deleteAddress(addressId);
            if(row>0){
                responseEntity = responseEntity.success(row);
            }else {
                responseEntity = responseEntity.error();
            }
        }catch (Exception e){
            responseEntity = responseEntity.error();
        }
        return responseEntity;
    }
}
