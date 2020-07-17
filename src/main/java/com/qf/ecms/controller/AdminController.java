package com.qf.ecms.controller;

import com.qf.ecms.domain.dto.AdminDto;
import com.qf.ecms.domain.dto.RoleDto;
import com.qf.ecms.domain.entity.Admin;
import com.qf.ecms.exception.ServiceException;
import com.qf.ecms.service.AdminDtoService;
import com.qf.ecms.utils.ErrorStatus;
import com.qf.ecms.utils.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Resource
    AdminDtoService adminDtoService;

    //管理员登录
    @RequestMapping("/login")
    public ResponseEntity<String> login(String adminName, String adminPassword) throws ServiceException {
        AdminDto admin = adminDtoService.selectByName(adminName,adminPassword);
        if(admin == null){
            return ResponseEntity.error();
        }
        return ResponseEntity.success("登陆成功！");

    }

    //显示管理员列表
    @GetMapping("/list")
    public ResponseEntity<List<AdminDto>> list(int page, int size) throws ServiceException{
        List<AdminDto> admins= adminDtoService.list(page, size);
        return ResponseEntity.success(admins);
    }

    //查询管理员
    @GetMapping("/select")
    public ResponseEntity<List<AdminDto>> select(String adminName,String createTime,int page,int size) throws ServiceException {
        List<AdminDto> admins = adminDtoService.selectByNameOrTime(adminName, createTime, page, size);
        return ResponseEntity.success(admins);
    }


    //添加管理员
    @PostMapping("/add")
    public ResponseEntity<Integer> insert(@RequestBody RoleDto roleDto) throws ServiceException{
        int count = adminDtoService.insert(roleDto);
        return ResponseEntity.success(count);
    }

    //修改管理员信息
    @PutMapping("/update")
    public ResponseEntity<Integer> update(@RequestBody AdminDto adminDto) throws ServiceException{
        int count = adminDtoService.update(adminDto);
        return ResponseEntity.success(count);
    }

    //删除管理员
    @DeleteMapping("/delete")
    public ResponseEntity<Integer> delete(int adminId) throws ServiceException{
        int count = adminDtoService.delete(adminId);
        return ResponseEntity.success(count);
    }

    //批量删除管理员
    @DeleteMapping("/deleteBatch")
    public ResponseEntity<Integer> deleteBatch(@RequestBody Map<String,List<Integer>> map) throws ServiceException{
        List<Integer> ids = map.get("ids");
        int count = adminDtoService.deleteBatch(ids);
        return ResponseEntity.success(count);
    }

    //激活管理员
    @PutMapping("/active")
    public ResponseEntity<Integer> active(int adminId) throws ServiceException{
        int count = adminDtoService.active(adminId);
        return ResponseEntity.success(count);
    }

    //管理员注销
    @RequestMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "login.html";
    }


}
