package com.qf.ecms.service;

import com.qf.ecms.domain.dto.UserDetailDto;

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
}
