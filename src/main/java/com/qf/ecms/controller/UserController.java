package com.qf.ecms.controller;

import com.qf.ecms.domain.dto.UserDetailDto;
import com.qf.ecms.domain.entity.User;
import com.qf.ecms.domain.entity.UserItem;
import com.qf.ecms.domain.entity.backstage.dto.UserDto;
import com.qf.ecms.exception.ServiceException;
import com.qf.ecms.service.UserDtoService;
import com.qf.ecms.service.UserService;
import com.qf.ecms.utils.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    UserService userService;
    @Resource
    UserDtoService userDtoService;

    /**
     * 用户详情请求controller
     * @param userId
     * @return 用户详情信息
     */
    @PostMapping("/detail")
    public ResponseEntity<UserDetailDto> FindUserInfo(int userId) {
        ResponseEntity<UserDetailDto> responseEntity = new ResponseEntity<>();
        try{
            UserDetailDto userDetail = userService.findUserDetail(userId);
            if(userDetail!=null){
                responseEntity = responseEntity.success(userDetail);
            }else {
                responseEntity = responseEntity.error();
            }
        }catch (Exception e){
            responseEntity = ResponseEntity.error();
        }
        return responseEntity;
    }


    /**
     * 修改密码请求controller
     * @param userId
     * @param password
     * @return
     */
    @PostMapping("/updatePassword")
    public ResponseEntity<Integer> FindUserInfo(int userId,String password) {
        ResponseEntity<Integer> responseEntity = new ResponseEntity<>();
        try{
            int row = userService.updatePassword(userId,password);
            if(row>0){
                responseEntity = responseEntity.success(row);
            }else {
                responseEntity = responseEntity.error();
            }
        }catch (Exception e){
            responseEntity = ResponseEntity.error();
        }
        return responseEntity;
    }

    @PostMapping("/updateItem")
    public ResponseEntity<Integer> updateUserItem(@RequestBody UserItem userItem){
        ResponseEntity<Integer> responseEntity = new ResponseEntity<>();
        try{
            int row = userService.updateUserItem(userItem);
            if(row>0){
                responseEntity = responseEntity.success(row);
            }else {
                responseEntity = responseEntity.error();
            }
        }catch (Exception e){
            responseEntity = ResponseEntity.error();
        }
        return responseEntity;
    }

    @GetMapping("/list")
    public ResponseEntity<List<User>> list(int page, int size) throws ServiceException {
        List<User> users = userDtoService.list(page, size);
        return ResponseEntity.success(users);
    }

    @GetMapping("/select")
    public ResponseEntity<List<User>> selectByNameOrTime(String userItemNickname, String createTime,int page,int size) throws ServiceException{
        List<User> users = userDtoService.selectByNameOrTime(userItemNickname,createTime,page,size);
        return ResponseEntity.success(users);
    }

    @PostMapping("/add")
    public ResponseEntity<Integer> add(@RequestBody UserDto userDto) throws ServiceException{
        int count = userDtoService.insert(userDto);
        return ResponseEntity.success(count);
    }
}

