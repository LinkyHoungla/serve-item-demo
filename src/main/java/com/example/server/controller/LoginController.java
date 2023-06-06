package com.example.server.controller;

import com.example.server.dao.UserDao;
import com.example.server.entity.ApiResponse;
import com.example.server.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LoginController {
    @Autowired
    private UserDao userDao;

    @PostMapping("/login")
    public ApiResponse<User> getUser(String username, String password){
        System.out.println("username:" + username);
        System.out.println("password:" + password);
        User user = userDao.getByLogin(username, password);
        return ApiResponse.success(user);
    }

    @GetMapping("/login")
    public String getUser2(){
        return "111";
    }
}
