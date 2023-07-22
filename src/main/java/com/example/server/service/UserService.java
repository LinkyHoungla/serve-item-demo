package com.example.server.service;

import com.example.server.model.entity.UserBasic;
import com.example.server.model.entity.UserInfo;
import com.example.server.model.entity.UserLogin;
import com.example.server.model.vo.UserInfoVo;
import com.github.pagehelper.PageInfo;


public interface UserService {
    // SECTION 用户 基本信息
    // function 获取 用户 基本信息 列表
    PageInfo<UserBasic> getUserBasicList(String query, Integer pageNum, Integer pageSize);
    // FUNCTION 获取 用户 基本信息
    UserBasic getUserBasic(String uid);
    // function 添加 用户
    Integer addUser(UserBasic userBasic);
    // function 修改 用户 手机号
    Integer updateUserPhone(String phone, String uid);
    // function 删除 用户
    Integer deleteUser(String uid);

    // SECTION 用户 登录信息
    // FUNCTION 用户登录
    String userLogin(String username, String password, String ip);
    // FUNCTION 用户登出
    Integer userLogout(String uid);
    // FUNCTION 获取 用户 登录信息
    UserLogin getUserLogin(String uid);
    // FUNCTION 修改 用户 登录信息
    Integer updateUserLogin(String uid, String username, String password);

    // SECTION 用户 个人信息
    // FUNCTION 获取 用户 个人信息
    UserInfo getUserInfo(String uid);
    // FUNCTION 修改 用户 个人信息
    Integer updateUserInfo(String uid, UserInfo userInfo);
    // FUNCTION 修改 用户 头像
    Integer updateAvatar(String avatar, String uid);
}
