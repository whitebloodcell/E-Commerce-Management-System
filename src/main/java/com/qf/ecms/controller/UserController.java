package com.qf.ecms.controller;

import com.qf.ecms.domain.dto.UserDetailDto;
import com.qf.ecms.service.UserService;
import com.qf.ecms.utils.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    UserService userService;

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
}
