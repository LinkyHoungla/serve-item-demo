package com.example.server.controller;

import com.example.server.dao.UserDao;
import com.example.server.entity.ApiResponse;
import com.example.server.entity.LoginInfo;
import com.example.server.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoginController {
    @Autowired
    private UserDao userDao;

    @CrossOrigin(origins = "http://192.168.2.100:8529")
    @PostMapping("/login")
    public ApiResponse<User> getUser(@RequestBody LoginInfo info){
        System.out.println("username:" + info.getUsername());
        System.out.println("password:" + info.getPassword());
        User user = userDao.getByLogin(info.getUsername(), info.getPassword());
        if(user == null) return ApiResponse.error(201,"用户名不存在或密码错误");
        return ApiResponse.success(user);
    }

    @GetMapping("/login")
    public String getUser2(){
        return "111";
    }
}
