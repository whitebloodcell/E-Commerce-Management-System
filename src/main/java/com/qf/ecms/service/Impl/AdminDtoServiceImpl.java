package com.qf.ecms.service.impl;

import com.qf.ecms.domain.dto.AdminDto;
import com.qf.ecms.domain.entity.Admin;
import com.qf.ecms.mapper.AdminDtoMapper;
import com.qf.ecms.service.AdminDtoService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class AdminDtoServiceImpl implements AdminDtoService {
    @Resource
    AdminDtoMapper adminDtoMapper;

    //管理员登录判断
    @Override
    public AdminDto selectByName(String adminName, String password) {
        AdminDto admin = adminDtoMapper.selectByName(adminName);
        if(admin == null ||!admin.getAdminPassword().equals(password)){
            return null;
        }
        return admin;
    }

    //显示管理员列表
    @Override
    public List<AdminDto> list(int page, int size) {
        int limit = (page - 1) * size;
        List<AdminDto> admins = new ArrayList<>();
        admins = adminDtoMapper.list(limit,size);
        return admins;
    }
}
