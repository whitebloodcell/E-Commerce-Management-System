package com.qf.ecms.controller;

import com.qf.ecms.domain.dto.AdminDto;
import com.qf.ecms.domain.entity.Admin;
import com.qf.ecms.service.AdminDtoService;
import com.qf.ecms.utils.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public String login(String adminName, String adminPassword, Model model, HttpSession session){
        AdminDto admin = adminDtoService.selectByName(adminName,adminPassword);
        if(admin == null){
            model.addAttribute("message","用户名或密码错误！");
            return "login.html";
        }
        return "redirect:index.html";

    }

    @GetMapping("/list")
    public ResponseEntity<List<AdminDto>> list(int page, int size){
        List<AdminDto> admins= adminDtoService.list(page, size);
        return ResponseEntity.success(admins);
    }












    //管理员注销
    @RequestMapping("/logout")
    public String logout(HttpSession session){
        session.invalidate();
        return "login.html";
    }


}
