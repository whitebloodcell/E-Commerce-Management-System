package com.qf.ecms.controller;

import com.qf.ecms.domain.dto.UserDto;
import com.qf.ecms.domain.entity.User;
import com.qf.ecms.domain.entity.UserItem;
import com.qf.ecms.exception.ServiceException;
import com.qf.ecms.service.LogInToRegisterService;
import com.qf.ecms.utils.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;
import javax.annotation.Resource;
import javax.servlet.http.HttpSession;


@RestController
public class LogInToRegisterController {


    @Resource
    LogInToRegisterService logInToRegisterService;

    /**
     * 登陆
     * 传入账号跟密码两个字段
     * 调用service层接口
     */
    @PostMapping("/login")

    public ResponseEntity<UserDto> login(HttpSession session, String userAccount, String password) throws ServiceException {

        UserDto userDto =logInToRegisterService.Login(userAccount, password);
        session.setAttribute("userDto",userDto);
        System.out.println(session.getAttribute("userDto"));
        return ResponseEntity.success(userDto);
    }


    @PostMapping("/register")
    public ResponseEntity<Integer> Register(@RequestBody User user)throws ServiceException{
        int count = logInToRegisterService.Register(user);
        return ResponseEntity.success(count);
    }
}
