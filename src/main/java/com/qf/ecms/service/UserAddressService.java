package com.qf.ecms.service;


import com.qf.ecms.domain.entity.UserAddress;

import java.util.List;

public interface UserAddressService {
    /**
     * 添加用户守护地址
     * @param userAddress 用户地址对象
     * @return
     */
    int addAddress (UserAddress userAddress);

    /**
     * 查找用户所有的收货地址
     * @param userId 用户id
     * @return
     */
    List<UserAddress> findAllAddress (int userId);
}
