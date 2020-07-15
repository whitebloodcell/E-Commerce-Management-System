package com.qf.ecms.controller;

import com.qf.ecms.domain.dto.RegisterDto;
import com.qf.ecms.domain.dto.UserDto;
import com.qf.ecms.exception.DaoException;
import com.qf.ecms.exception.ServiceException;
import com.qf.ecms.service.ReceptionLogInToRegisterService;
import com.qf.ecms.utils.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;


@RestController
public class ReceptionLogInToRegisterController {


    @Resource
    ReceptionLogInToRegisterService logInToRegisterService;

    /**
     * 登陆
     * 传入账号跟密码两个字段
     * 调用service层接口
     */
    @PostMapping("/login")

    public ResponseEntity<UserDto> login(HttpSession session, String userAccount, String password) throws DaoException {

        UserDto userDto =logInToRegisterService.Login(userAccount, password);
        session.setAttribute("userDto",userDto);
        return ResponseEntity.success(userDto);
    }


    @PostMapping("/register")
    public ResponseEntity<Integer> Register(@RequestBody RegisterDto registerDto) throws DaoException{
        int count = logInToRegisterService.Register(registerDto);
        return ResponseEntity.success(count);
    }
}
