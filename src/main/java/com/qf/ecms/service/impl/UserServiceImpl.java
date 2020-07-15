package com.qf.ecms.service.impl;

import com.qf.ecms.domain.dto.UserDetailDto;
import com.qf.ecms.domain.entity.UserItem;
import com.qf.ecms.mapper.UserDetailMapper;
import com.qf.ecms.mapper.UserItemMapper;
import com.qf.ecms.mapper.UserMapper;
import com.qf.ecms.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    UserDetailMapper userDetailMapper;
    @Resource
    UserMapper userMapper;
    @Resource
    UserItemMapper userItemMapper;
    /**
     * 根据用户id查找用户详细信息
     * @param userId
     * @return
     */
    @Override
    public UserDetailDto findUserDetail(int userId) {
        return userDetailMapper.selectUserDetail(userId);
    }

    /**
     * 根据用户id修改用户密码
     * @param userId
     * @param password
     * @return
     */
    @Override
    public int updatePassword(int userId, String password) {
        return userMapper.updatePassword(userId,password);
    }

    /**
     * 修改用户详细信息
     * @param userItem
     * @return
     */
    @Override
    public int updateUserItem(UserItem userItem) {
        return userItemMapper.updateUserItemById(userItem);
    }


}
