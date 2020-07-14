package com.qf.ecms.service.Impl;

import com.qf.ecms.domain.dto.UserDto;
import com.qf.ecms.domain.entity.User;
import com.qf.ecms.domain.entity.UserItem;
import com.qf.ecms.exception.ServiceException;
import com.qf.ecms.mapper.UserItemMapper;
import com.qf.ecms.mapper.UserMapper;
import com.qf.ecms.service.LogInToRegisterService;
import com.qf.ecms.utils.ErrorStatus;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;

@Service
public class LogInToRegisterServiceImpl implements LogInToRegisterService {

    @Resource
    UserMapper userMapper;
    @Resource
    UserItemMapper userItemMapper;



    /**
     * 登陆根据用户名查询数据库,数据存在则比较password是否一样
     * 一样则返回用户对象给Controller层
     * 不一样则返回null
     * @param userAccount
     * @param password
     * @return
     */

    @Override
    public UserDto Login(String userAccount, String password) throws ServiceException {

        User user = userMapper.selectByUserAccount(userAccount);


        if (user!=null){
            if (password.equals(user.getUserPassword())){
                UserItem userItem = userItemMapper.selectByUserId(user.getUserId());
                UserDto userDto = new UserDto();
                userDto.setUserId(user.getUserId());
                userDto.setUserAccount(user.getUserAccount());
                userDto.setUserItem(userItem);
                return userDto;
            }else {
                throw new ServiceException(ErrorStatus.SERVICE_ERROR);
            }
        }else {
            throw new ServiceException(ErrorStatus.SERVICE_ERROR);
        }
    }

    @Override
    public int Register(User user) throws ServiceException {
        int count=0;
        //判断用户名是否存在
        User judge = userMapper.selectByUserAccount(user.getUserAccount());
        if(judge!=null){
           throw new ServiceException(ErrorStatus.REGISTER_ERROR);
        }
        count  = userMapper.insertUser(user);
        return count;
    }
}
