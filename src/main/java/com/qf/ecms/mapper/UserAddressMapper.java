package com.qf.ecms.mapper;

import com.qf.ecms.domain.entity.UserAddress;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserAddressMapper {
    /**
     * 插入用户收货地址
     * @param userAddress 用户地址对象
     * @return
     */
    int insertAddress(@Param("userAddress") UserAddress userAddress);

    /**
     * 查询用户收货地址数
     * @param userId  用户id
     * @return
     */
    int selectAddressCount (@Param("userId") int userId);

    /**
     * 根据用户id查询所有收货地址记录
     * @param userId
     * @return
     */
    List<UserAddress> selectAllAddressByUserId (@Param("userId") int userId);

    /**
     * 根据收货地址主键修改收货地址
     * @param userAddress
     * @return
     */
    int updateAddressByUserId(@Param("userAddress") UserAddress userAddress);

    /**
     * 根据收货地址主键修改收货地址假删除字段为1
     * @param addressId
     * @return
     */
    int updateAddressIsDel(@Param("addressId") int addressId);
}