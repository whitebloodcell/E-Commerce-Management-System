package com.qf.ecms.service;

import com.qf.ecms.domain.dto.UserDto;
import com.qf.ecms.domain.entity.User;
import com.qf.ecms.exception.ServiceException;

public interface LogInToRegisterService {
    //登陆
    UserDto Login(String userAccount , String password) throws ServiceException;

    int Register(User user)throws ServiceException;

}
