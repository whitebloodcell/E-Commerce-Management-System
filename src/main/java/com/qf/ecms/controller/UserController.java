package com.qf.ecms.controller;

import com.qf.ecms.domain.entity.User;
import com.qf.ecms.exception.ServiceException;
import com.qf.ecms.service.UserDtoService;
import com.qf.ecms.utils.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    UserDtoService userDtoService;

    @GetMapping("/list")
    public ResponseEntity<List<User>> list(int page, int size) throws ServiceException {
        List<User> users = userDtoService.list(page, size);
        return ResponseEntity.success(users);
    }
}

