package com.qf.ecms.controller;

import com.qf.ecms.domain.entity.Admin;
import com.qf.ecms.service.AdminDtoService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @Resource
    AdminDtoService adminDtoService;

    @RequestMapping("/login")
    public String login(String adminName, String adminPassword, Model model, HttpSession session){
        Admin admin = adminDtoService.selectByName(adminName,adminPassword);
        if(admin == null){
            model.addAttribute("message","用户名或密码错误！");
            return "login.html";
        }
        return "redirect:index.html";

    }


}
