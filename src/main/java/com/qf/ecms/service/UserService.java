package com.qf.ecms.service;

import com.qf.ecms.domain.dto.UserDetailDto;
import com.qf.ecms.domain.entity.UserItem;

public interface UserService {
    /**
     * 根据用户id查找用户详细信息
     * @param userId
     * @return
     */
    UserDetailDto findUserDetail (int userId);

    /**
     * 根据用户id修改用户密码
     * @param userId
     * @param password
     * @return
     */
    int updatePassword (int userId,String password);

    /**
     * 修改用户详细信息
     * @param userItem
     * @return
     */
    int updateUserItem(UserItem userItem);
}
