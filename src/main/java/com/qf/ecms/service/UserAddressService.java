package com.qf.ecms.service;


import com.qf.ecms.domain.entity.UserAddress;
import com.qf.ecms.exception.ServiceException;

import java.util.List;

public interface UserAddressService {
    /**
     * 添加用户守护地址
     * @param userAddress 用户地址对象
     * @return
     */
    int addAddress (UserAddress userAddress) throws ServiceException;

    /**
     * 查找用户所有的收货地址
     * @param userId 用户id
     * @return
     */
    List<UserAddress> findAllAddress (int userId);

    /**
     * 修改用户收货地址
     * @param userAddress
     * @return
     */
    int updateUserAddress (UserAddress userAddress);

    /**
     * 根据购物车id删除购物车记录
     * @param addressId
     * @return
     */
    int deleteAddress(int addressId);
}
