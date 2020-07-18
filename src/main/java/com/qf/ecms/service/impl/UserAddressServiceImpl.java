package com.qf.ecms.service.impl;

import com.qf.ecms.domain.entity.UserAddress;
import com.qf.ecms.exception.ServiceException;
import com.qf.ecms.mapper.UserAddressMapper;
import com.qf.ecms.service.UserAddressService;
import com.qf.ecms.utils.ErrorStatus;
import com.qf.ecms.utils.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserAddressServiceImpl implements UserAddressService {
    @Resource
    UserAddressMapper userAddressMapper;

    /**
     * 添加用户收货地址
     *
     * 1.查询收货地址保存数
     * 2.保存数等于10则跑出异常
     * 3.判断前端传过来的购物车是否是设为默认
     * 4.是默认则修改之前默认的地址为非默认
     * 5.添加当前收货地址到数据库
     *
     * @param userAddress 用户地址对象
     * @return
     */
    @Transactional
    @Override
    public int addAddress(UserAddress userAddress) throws ServiceException {
        ResponseEntity<Integer> responseEntity = new ResponseEntity<>();
        //插入条数
        int row = 0;
        //查询用户保存的记录数
        int count = userAddressMapper.selectAddressCount(userAddress.getUserId());
        //保存记录等于10代表记录数已满
        if(count>=10){
            throw new ServiceException("收货地址最多只能添加10条",20000);
        }else if(userAddress.getIsDefault()==1){
            //把所有当前用户的地址设为非默认
            userAddressMapper.updateAddressUnDefault(userAddress.getUserId());
            //插入收货地址
            row = userAddressMapper.insertAddress(userAddress);
        }else {
            //插入收货地址
            row = userAddressMapper.insertAddress(userAddress);
        }
        return row;
    }

    /**
     * 查找用户所有的收货地址
     * @param userId 用户id
     * @return
     */
    @Override
    public List<UserAddress> findAllAddress(int userId) {
        return userAddressMapper.selectAllAddressByUserId(userId);
    }

    /**
     * 修改用户收货地址
     * @param userAddress
     * @return
     */
    @Override
    public int updateUserAddress(UserAddress userAddress) {
        return userAddressMapper.updateAddressByUserId(userAddress);
    }

    /**
     * 根据购物车id删除购物车记录
     * @param addressId
     * @return
     */
    @Override
    public int deleteAddress(int addressId) {
        return userAddressMapper.updateAddressIsDel(addressId);
    }

    /**
     * 修改默认的收货地址
     *
     * 1.把所有地址设为非默认
     * 2.把需要设为默认的地址设为默认
     *
     * @param userId 用户ID
     * @param addressId 地址表ID
     * @return
     */
    @Override
    @Transactional
    public int updateDefaultAddress(int userId, int addressId) throws ServiceException{
        //把所有地址设为非默认
        userAddressMapper.updateAddressUnDefault(userId);
        int row = userAddressMapper.updateAddressDefault(addressId);
        return row;
    }


}
