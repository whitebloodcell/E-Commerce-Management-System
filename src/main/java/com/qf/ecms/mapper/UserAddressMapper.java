package com.qf.ecms.mapper;

import com.qf.ecms.domain.entity.UserAddress;

public interface UserAddressMapper {
    int deleteByPrimaryKey(Integer addressId);

    int insert(UserAddress record);

    int insertSelective(UserAddress record);

    UserAddress selectByPrimaryKey(Integer addressId);

    int updateByPrimaryKeySelective(UserAddress record);

    int updateByPrimaryKey(UserAddress record);
}