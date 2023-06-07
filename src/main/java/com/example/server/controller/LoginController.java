package com.example.server.controller;

import com.example.server.dao.UserDao;
import com.example.server.entity.Admin;
import com.example.server.entity.ApiResponse;
import com.example.server.entity.LoginInfo;
import com.example.server.entity.User;
import com.example.server.service.impl.AdminServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoginController {
    @Autowired
    private UserDao userDao;
    @Autowired
    private AdminServiceImpl adminService;

//    @CrossOrigin(origins = "http://localhost:8529")
    @PostMapping("/login")
    public ApiResponse<User> getUser(@RequestBody LoginInfo info){
        System.out.println("username:" + info.getUsername());
        System.out.println("password:" + info.getPassword());
        User user = userDao.getByLogin(info.getUsername(), info.getPassword());
        if(user == null) return ApiResponse.error(201,"用户名不存在或密码错误");
        return ApiResponse.success(user);
    }

    @GetMapping("/admin")
    public ApiResponse<Admin> getAdminById(Integer account){
        Admin admin = adminService.getAdminById(account);
        if(admin == null) return ApiResponse.error(201,"用户名不存在或密码错误");
        return ApiResponse.success(admin);
    }

    @PostMapping ("/admin/login")
    public ApiResponse<LoginInfo> getAdminByLogin(@RequestBody LoginInfo info){
        LoginInfo loginInfo = adminService.getAdminByLogin(info.getUsername(), info.getPassword());
        if(loginInfo == null) return ApiResponse.error(201,"用户名不存在或密码错误");
        return ApiResponse.success(loginInfo);
    }
}
