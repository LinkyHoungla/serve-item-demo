package com.example.server.service.impl;

import com.example.server.dao.AdminDao;
import com.example.server.entity.Admin;
import com.example.server.entity.LoginInfo;
import com.example.server.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminDao adminDao;

    @Override
    public Admin getAdminById(Integer account) {
        return adminDao.getAdminById(account);
    }

    @Override
    public Integer getTotalNum() {
        return adminDao.getTotalNum();
    }

    @Override
    public LoginInfo getAdminByLogin(String username, String password) {
        Admin admin = adminDao.getAdminByLogin(username, password);
        if(admin == null) return null;
        return LoginInfo.success(admin.getUsername(), admin.getRole());
    }

    @Override
    public List<Admin> getAllAdmin() {
        return null;
    }

    @Override
    public List<Admin> getAdminByPage(Integer pageNum, Integer pageSize) {
        return adminDao.getAdminByPage(pageNum, pageSize);
    }

    @Override
    public void createAdmin(Admin admin) {

    }

    @Override
    public void updateAdmin(Admin admin) {

    }

    @Override
    public void deleteAdmin(Admin admin) {

    }
}
