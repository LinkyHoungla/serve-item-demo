package com.example.server.service.impl;

import com.example.server.constant.ApiError;
import com.example.server.dao.UserDao;
import com.example.server.exception.ApiException;
import com.example.server.model.entity.UserBasic;
import com.example.server.model.entity.UserInfo;
import com.example.server.model.entity.UserLogin;
import com.example.server.service.UserService;
import com.example.server.util.JwtUtil;
import com.example.server.util.Uuid;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public PageInfo<UserBasic> getUserBasicList(String query, Integer pageNum, Integer pageSize) {
        // 使用PageHelper进行分页设置
        PageHelper.startPage(pageNum, pageSize);
        // 调用分页查询的方法
        Page<UserBasic> userInfoVos = userDao.getUserBasicList(query);
        // 封装分页结果为PageInfo对象
        return new PageInfo<>(userInfoVos);
    }

    @Override
    public UserBasic getUserBasic(String uid) {
        return userDao.getUserBasic(uid);
    }

    @Override
    @Transactional
    public Integer addUser(UserBasic userBasic) {
        while (true) {
            userBasic.setUid(Uuid.generateUniqueId());
            userBasic.setWalletId(Uuid.generateUniqueId());
            try {
                int len = userDao.addUser(userBasic);
                if (len > 0) {
                    return len; // 插入成功，返回插入的行数
                }
            } catch (DuplicateKeyException e) {
                // 插入失败，继续循环生成新的 UID
            }
        }
    }

    @Override
    public Integer updateUserPhone(String phone, String uid) {
        return userDao.updateUserPhone(phone, uid);
    }

    @Override
    public Integer deleteUser(String uid) {
        return userDao.delete(uid);
    }

    @Override
    public String userLogin(String username, String password, String ip) {
        String uid = userDao.getUserLoginId(username, password);
        if (uid == null)
            throw new ApiException(ApiError.E401);
        else
            userDao.userLogin(ip, username, password, new Date());
        return JwtUtil.generateToken(uid, ip, null);
    }

    @Override
    public Integer userLogout(String uid) {
        return null;
    }

    @Override
    public UserLogin getUserLogin(String uid) {
        return userDao.getUserLogin(uid);
    }

    @Override
    public Integer updateUserLogin(String uid, String username, String password) {
        return userDao.updateUserLogin(uid, username, password);
    }

    @Override
    public UserInfo getUserInfo(String uid) {
        return userDao.getUserInfo(uid);
    }

    @Override
    public Integer updateUserInfo(String uid, UserInfo userInfo) {
        userInfo.setUid(uid);
        return userDao.updateUserInfo(userInfo);
    }

    @Override
    public Integer updateAvatar(String avatar, String uid) {
        return null;
    }
}
