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

    /**
     * 添加收货地址请求方法
     * @param userAddress 收货地址对象
     * @return
     */
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

    /**
     * 查找收货地址请求方法
     * @param userId 用户id
     * @return
     */
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

    /**
     * 修改收货地址信息请求方法
     * @param userAddress 收货地址对象
     * @return
     */
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

    /**
     * 删除收货地址请求方法
     * @param addressId 收货地址id
     * @return
     */
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

    /**
     * 修改默认收货地址请求方法
     * @param userId 用户id
     * @param addressId 收货地址id
     * @return
     */
    @PostMapping("/default")
    public ResponseEntity<Integer> updateAddressDefault(int userId,int addressId){
        ResponseEntity<Integer> responseEntity = new ResponseEntity<>();
        try{
            int row = userAddressService.updateDefaultAddress(userId,addressId);
            if(row>0){
                responseEntity = responseEntity.success(row);
            }else {
                responseEntity = responseEntity.error(40005,"修改默认地址失败");
            }
        }catch (Exception e){
            responseEntity = responseEntity.error();
        }
        return responseEntity;
    }
}
