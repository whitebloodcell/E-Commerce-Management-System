package com.qf.ecms.service.impl;

import com.qf.ecms.domain.dto.AdminDetailDto;
import com.qf.ecms.domain.dto.AdminDto;
import com.qf.ecms.domain.dto.RoleDto;
import com.qf.ecms.domain.entity.Admin;
import com.qf.ecms.domain.entity.Role;
import com.qf.ecms.mapper.AdminDetailDtoMapper;
import com.qf.ecms.mapper.AdminDtoMapper;
import com.qf.ecms.mapper.RoleDtoMapper;
import com.qf.ecms.service.AdminDtoService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class AdminDtoServiceImpl implements AdminDtoService {
    @Resource
    AdminDtoMapper adminDtoMapper;

    @Resource
    RoleDtoMapper roleDtoMapper;

    @Resource
    AdminDetailDtoMapper adminDetailDtoMapper;

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

    //查询管理员
    @Override
    public List<AdminDto> selectByNameOrTime(String adminName, String createTime, int page, int size) {
        int limit = (page - 1) * size;
        List<AdminDto> admins = new ArrayList<>();
        admins = adminDtoMapper.selectByNameOrTime(adminName,createTime,limit,size);
        return admins;
    }

    //添加管理员
    @Override
    @Transactional
    public int insert(RoleDto roleDto) {
        int count = 0;
        count = roleDtoMapper.insert(roleDto);
        int roleId = roleDto.getRoleId();
        int count2 = 0;
        int count3 = 0;
        for(AdminDto adminDto:roleDto.getAdmins()){
            adminDto.setRoleId(roleId);
            count2 = adminDtoMapper.insert(adminDto);
            int adminId = adminDto.getAdminId();
            AdminDetailDto adminDetailDto = adminDto.getAdminDetailDto();
            adminDetailDto.setAdminId(adminId);
            count3 = adminDetailDtoMapper.insert(adminDetailDto);

        }
        return count3;
    }


    //修改管理员信息
    @Override
    public int update(AdminDto adminDto) {
        int count = 0;
        count = adminDtoMapper.update(adminDto);
        AdminDetailDto adminDetailDto = adminDto.getAdminDetailDto();
        adminDetailDto.setAdminId(adminDto.getAdminId());
        int count2 = adminDetailDtoMapper.update(adminDetailDto);
        RoleDto roleDto = adminDto.getRoleDto();
        roleDto.setRoleId(adminDto.getRoleId());
        int count3 = roleDtoMapper.update(roleDto);
        return count3;
    }

    //删除管理员
    @Override
    public int delete(int adminId) {
        int count = 0;
        count = adminDtoMapper.delete(adminId);
        return count;
    }


    //批量删除管理员
    @Override
    public int deleteBatch(List<Integer> adminIds) {
        int count = 0;
        count = adminDtoMapper.deleteBatch(adminIds);
        return count;
    }

    //激活管理员
    @Override
    public int active(int adminId) {
        int count = 0;
        count = adminDtoMapper.active(adminId);
        return count;
    }
}
