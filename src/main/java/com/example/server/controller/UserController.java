package com.example.server.controller;

import com.example.server.model.ApiResponse;
import com.example.server.model.entity.UserBasic;
import com.example.server.model.entity.UserInfo;
import com.example.server.model.entity.UserLogin;
import com.example.server.model.param.LoginParam;
import com.example.server.service.impl.UserServiceImpl;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @PostMapping("/login")
    public ApiResponse<String> userLogin(@RequestBody LoginParam info, HttpServletRequest request) {
        return ApiResponse.success(userService.userLogin(info.getUsername(), info.getPassword(), request.getRemoteAddr()));
    }

    @GetMapping("/list")
    public ApiResponse<PageInfo<UserBasic>> getUserBasicList(String query, Integer pageNum, Integer pageSize) {
        return ApiResponse.success(userService.getUserBasicList(query, pageNum, pageSize));
    }

    @GetMapping("/{uid}")
    public ApiResponse<UserBasic> getUserBasic(@PathVariable("uid")String uid){
        return ApiResponse.success(userService.getUserBasic(uid));
    }

    @PostMapping
    public ApiResponse<Integer> addUser(@RequestBody UserBasic userBasic){
        return ApiResponse.success(userService.addUser(userBasic));
    }

    @PutMapping("/{uid}")
    public ApiResponse<Integer> updateUserPhone(@PathVariable("uid") String uid, @RequestBody String phone){
        return ApiResponse.success(userService.updateUserPhone(phone, uid));
    }

    @DeleteMapping("/{uid}")
    public ApiResponse<Integer> deleteUser(@PathVariable("uid") String uid){
        return ApiResponse.success(userService.deleteUser(uid));
    }

    @GetMapping("/info/{uid}")
    public ApiResponse<UserInfo> getUserInfo(@PathVariable("uid")String uid){
        return ApiResponse.success(userService.getUserInfo(uid));
    }

    @PutMapping("/info/{uid}")
    public ApiResponse<Integer> updateUserInfo(@PathVariable("uid") String uid, @RequestBody UserInfo userInfo){
        return ApiResponse.success(userService.updateUserInfo(uid, userInfo));
    }

    @GetMapping("/log/{uid}")
    public ApiResponse<UserLogin> getUserLogin(@PathVariable("uid")String uid){
        return ApiResponse.success(userService.getUserLogin(uid));
    }

    @PutMapping("/log/{uid}")
    public ApiResponse<Integer> updateUserLogin(@PathVariable("uid") String uid, @RequestBody UserLogin userLogin){
        return ApiResponse.success(userService.updateUserLogin(uid, userLogin.getUsername(), userLogin.getPassword()));
    }

}
