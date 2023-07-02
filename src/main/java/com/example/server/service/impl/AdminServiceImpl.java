package com.example.server.service.impl;

import com.example.server.constant.ApiError;
import com.example.server.dao.AdminDao;
import com.example.server.exception.ApiException;
import com.example.server.model.Admin;
import com.example.server.model.LoginInfo;
import com.example.server.service.AdminService;
import com.example.server.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminDao adminDao;

    @Override
    public Admin getAdminById(Integer account) {
        return adminDao.getAdminById(account);
    }

    @Override
    public Admin getAdminByName(String name) {
        return adminDao.getAdminByName(name);
    }

    @Override
    public Integer getTotalNum(String query) {
        return adminDao.getTotalNum(query);
    }

    @Override
    public String getAdminByLogin(String username, String password) {
        Admin admin = adminDao.getAdminByLogin(username, password);
        if(admin == null) throw new ApiException(ApiError.E401);
        return JwtUtil.generateToken(admin.getUsername());
    }

    @Override
    public List<Admin> getAllAdmin() {
        return null;
    }

    @Override
    public List<Admin> getAdminByPage(String query, Integer pageNum, Integer pageSize) {
         return adminDao.getAdminByPage(query, pageNum, pageSize);
    }

    @Override
    public Integer createAdmin(Admin admin) {
       return adminDao.createAdmin(admin);
    }

    @Override
    public Integer updateAdmin(Admin admin) {
        return adminDao.updateAdmin(admin);
    }

    @Override
    public Integer deleteAdminById(Integer account) {
        return adminDao.deleteAdminById(account);
    }
}
