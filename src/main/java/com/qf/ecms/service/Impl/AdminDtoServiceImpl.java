package com.qf.ecms.service.impl;

import com.qf.ecms.domain.entity.Admin;
import com.qf.ecms.mapper.AdminDtoMapper;
import com.qf.ecms.service.AdminDtoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class AdminDtoServiceImpl implements AdminDtoService {
    @Resource
    AdminDtoMapper adminDtoMapper;

    //管理员登录判断
    @Override
    public Admin selectByName(String adminName,String password) {
        Admin admin = adminDtoMapper.selectByName(adminName);
        if(admin == null ||!admin.getAdminPassword().equals(password)){
            return null;
        }
        return admin;
    }
}
