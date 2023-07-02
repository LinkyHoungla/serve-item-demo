package com.example.server.controller;

import com.example.server.dao.UserDao;
import com.example.server.model.ApiResponse;
import com.example.server.model.LoginInfo;
import com.example.server.model.User;
import com.example.server.service.impl.AdminServiceImpl;
import com.example.server.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private UserDao userDao;
    @Autowired
    private AdminServiceImpl adminService;

//    @CrossOrigin(origins = "http://localhost:8529")
    @PostMapping
    public ApiResponse<User> getUser(@RequestBody LoginInfo info){
        User user = userDao.getByLogin(info.getUsername(), info.getPassword());
        if(user == null) return ApiResponse.error(201,"用户名不存在或密码错误");
        return ApiResponse.success(user);
    }

    @PostMapping ("/admin")
    public ApiResponse<Map<String, Object>> getAdminByLogin(@RequestBody LoginInfo info){
        String token = adminService.getAdminByLogin(info.getUsername(), info.getPassword());
        Map<String, Object> set = new HashMap<>();
        set.put("token", token);
        return ApiResponse.success(set);
    }
}
