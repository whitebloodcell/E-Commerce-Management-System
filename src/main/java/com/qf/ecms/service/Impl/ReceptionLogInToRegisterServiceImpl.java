package com.qf.ecms.service.Impl;

import com.qf.ecms.domain.dto.RegisterDto;
import com.qf.ecms.domain.dto.UserDto;
import com.qf.ecms.domain.entity.User;
import com.qf.ecms.domain.entity.UserItem;
import com.qf.ecms.exception.DaoException;
import com.qf.ecms.exception.ServiceException;
import com.qf.ecms.mapper.ReceptionUserItemMapper;
import com.qf.ecms.mapper.ReceptionUserMapper;
import com.qf.ecms.service.ReceptionLogInToRegisterService;
import com.qf.ecms.utils.ErrorStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class ReceptionLogInToRegisterServiceImpl implements ReceptionLogInToRegisterService {

    @Resource
    ReceptionUserMapper receptionUserMapper;
    @Resource
    ReceptionUserItemMapper receptionUserItemMapper;



    /**
     * 登陆根据用户名查询数据库,数据存在则比较password是否一样
     * 一样则返回用户对象给Controller层
     * 不一样则返回null
     * @param userAccount
     * @param password
     * @return
     */

    @Override
    public UserDto Login(String userAccount, String password){

        User user = receptionUserMapper.selectByUserAccount(userAccount);


        if (user!=null){
            if (password.equals(user.getUserPassword())){
                UserItem userItem = receptionUserItemMapper.selectByUserId(user.getUserId());
                UserDto userDto = new UserDto();
                userDto.setUserId(user.getUserId());
                userDto.setUserAccount(user.getUserAccount());
                userDto.setUserItem(userItem);
                return userDto;
            }else {
                return null;
            }
        }else {
            throw new DaoException(ErrorStatus.SERVICE_ERROR);
        }
    }

    @Override
    @Transactional
    public int Register(RegisterDto registerDto) {

        //user对象
        User user = registerDto.getUser();
        //用户账号
        String userAccount = user.getUserAccount();
        //手机号
        String userItemPhone = registerDto.getPhone();
        //邮箱
        String userItemEmail = registerDto.getEmail();
        //判断用户名是否存在
        User judge = receptionUserMapper.selectByUserAccount(userAccount);
        if(judge!=null){
           throw new DaoException(ErrorStatus.REGISTER_NAME_ERROR);
        }

        //判断手机号是否存在
        UserItem phone = receptionUserItemMapper.selectByPhone(userItemPhone);
        if (phone!=null){
            throw new DaoException(ErrorStatus.REGISTER_PHONE_ERROR);
        }

        //判断邮箱是否存在
        UserItem email = receptionUserItemMapper.selectByEmail(userItemEmail);
        if (email!=null){
            throw new DaoException(ErrorStatus.REGISTER_EMAIL_ERROR);
        }
        //添加用户信息到用户表
        int registerUser  = receptionUserMapper.insertUser(user);
        if (registerUser==0){
            throw new DaoException(ErrorStatus.DAO_ERROR);
        }
        //添加用户id、手机号、邮箱到用户详情表
        UserItem userItem = new UserItem();
        userItem.setUserId(user.getUserId());
        userItem.setUserItemPhone(userItemPhone);
        userItem.setUserItemEmail(userItemEmail);

        int  registerAddPhoneAndEmail = receptionUserItemMapper.insertPhoneAndEmail(userItem);
        if (registerAddPhoneAndEmail==0){
            throw new DaoException(ErrorStatus.DAO_ERROR);
        }
        int count=registerUser * registerAddPhoneAndEmail;

        return count;
    }
}
