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

    //显示所有会员
    @GetMapping("/list")
    public ResponseEntity<List<UserDto>> list(int page, int size) throws ServiceException {
        List<UserDto> users = userDtoService.list(page, size);
        return ResponseEntity.success(users);
    }

    //查询会员
    @GetMapping("/select")
    public ResponseEntity<List<UserDto>> selectByNameOrTime(String userItemNickname, String createTime,int page,int size) throws ServiceException{
        List<UserDto> users = userDtoService.selectByNameOrTime(userItemNickname,createTime,page,size);
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
        int count = userDtoService.updateById(userDto);
        return ResponseEntity.success(count);

    }
}

