package com.qf.ecms.controller;

import com.qf.ecms.domain.dto.AdminDto;
import com.qf.ecms.domain.dto.RoleDto;
import com.qf.ecms.domain.entity.Admin;
import com.qf.ecms.exception.ServiceException;
import com.qf.ecms.service.AdminDtoService;
import com.qf.ecms.utils.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Resource
    AdminDtoService adminDtoService;

    //管理员登录
    @RequestMapping("/login")
    public String login(String adminName, String adminPassword, Model model, HttpSession session) throws ServiceException {
        AdminDto admin = adminDtoService.selectByName(adminName,adminPassword);
        if(admin == null){
            model.addAttribute("message","用户名或密码错误！");
            return "login.html";
        }
        return "redirect:index.html";

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

    //管理员注销
    @RequestMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "login.html";
    }


}
