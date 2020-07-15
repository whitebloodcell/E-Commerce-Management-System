package com.qf.ecms.controller;

import com.qf.ecms.domain.entity.User;
import com.qf.ecms.domain.entity.backstage.dto.UserDto;
import com.qf.ecms.exception.ServiceException;
import com.qf.ecms.service.UserDtoService;
import com.qf.ecms.utils.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    UserDtoService userDtoService;

    //显示所有会员
    @GetMapping("/list")
    public ResponseEntity<List<User>> list(int page, int size) throws ServiceException {
        List<User> users = userDtoService.list(page, size);
        return ResponseEntity.success(users);
    }

    //查询会员
    @GetMapping("/select")
    public ResponseEntity<List<User>> selectByNameOrTime(String userItemNickname, String createTime,int page,int size) throws ServiceException{
        List<User> users = userDtoService.selectByNameOrTime(userItemNickname,createTime,page,size);
        return ResponseEntity.success(users);
    }

    //删除会员
    @DeleteMapping("/delete")
    public ResponseEntity<Integer> delete(int userId) throws ServiceException{
        int count = userDtoService.delete(userId);
        return ResponseEntity.success(count);

    }

    //批量删除
    @DeleteMapping("/deleteBatch")
    public ResponseEntity<Integer> deleteBatch(List<Integer> ids) throws ServiceException{
        int count = userDtoService.deleteBatch(ids);
        return ResponseEntity.success(count);

    }

    //启用会员
    @PutMapping("/active")
    public ResponseEntity<Integer> active(int userId) throws ServiceException{
        int count = userDtoService.active(userId);
        return ResponseEntity.success(count);
    }

    //添加会员
    @PostMapping("/add")
    public ResponseEntity<Integer> add(@RequestBody UserDto userDto) throws ServiceException{
        int count = userDtoService.insert(userDto);
        return ResponseEntity.success(count);
    }

    //修改会员信息
    @PutMapping("/update")
    public ResponseEntity<Integer> updateByPrimaryKey(UserDto userDto) throws ServiceException{
        int count = userDtoService.updateByPrimaryKey(userDto);
        return ResponseEntity.success(count);

    }




}

