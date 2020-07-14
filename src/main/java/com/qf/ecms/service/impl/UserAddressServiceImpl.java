package com.qf.ecms.service.impl;

import com.qf.ecms.domain.entity.UserAddress;
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
     * 添加用户守护地址
     * @param userAddress 用户地址对象
     * @return
     */
    @Transactional
    @Override
    public int addAddress(UserAddress userAddress) {
        ResponseEntity<Integer> responseEntity = new ResponseEntity<>();
        //插入条数
        int row = 0;
        //查询用户保存的记录数
        int count = userAddressMapper.selectAddressCount(userAddress.getUserId());
        //保存记录等于10代表记录数已满,不满则插入数据
        if(count==10){
            responseEntity.error(ErrorStatus.DATA_ERROR);
            return 0;
        }else {
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


}
