package com.example.server.service;

import com.example.server.entity.Admin;
import com.example.server.entity.LoginInfo;

import java.util.List;

public interface AdminService {
    Admin getAdminById(Integer id);
    Integer getTotalNum(String query);
    LoginInfo getAdminByLogin(String username, String password);
    List<Admin> getAllAdmin();
    List<Admin> getAdminByPage(String query, Integer pageNum, Integer pageSize);
    void createAdmin(Admin admin);
    void updateAdmin(Admin admin);
    void deleteAdmin(Admin admin);
}
