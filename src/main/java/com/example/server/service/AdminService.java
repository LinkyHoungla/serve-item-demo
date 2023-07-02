package com.example.server.service;

import com.example.server.model.Admin;
import com.example.server.model.LoginInfo;

import java.util.List;

public interface AdminService {
    Admin getAdminById(Integer id);
    Admin getAdminByName(String name);
    Integer getTotalNum(String query);
    LoginInfo getAdminByLogin(String username, String password);
    List<Admin> getAllAdmin();
    List<Admin> getAdminByPage(String query, Integer pageNum, Integer pageSize);
    Integer createAdmin(Admin admin);
    Integer updateAdmin(Admin admin);
    Integer deleteAdminById(Integer account);
}
