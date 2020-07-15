package com.qf.ecms.service;

import com.qf.ecms.domain.dto.RegisterDto;
import com.qf.ecms.domain.dto.UserDto;
import com.qf.ecms.domain.entity.User;
import com.qf.ecms.exception.DaoException;
import com.qf.ecms.exception.ServiceException;

public interface ReceptionLogInToRegisterService {
    //登陆
    UserDto Login(String userAccount , String password) throws DaoException;

    int Register(RegisterDto registerDto)throws DaoException;

}
