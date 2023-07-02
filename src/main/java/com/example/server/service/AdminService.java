package com.example.server.service;

import com.example.server.model.entity.AdminInfo;
import com.example.server.model.entity.AdminLogin;
import com.example.server.model.vo.LoginAdminVo;

import java.util.List;

public interface AdminService {
    AdminInfo getAdminById(Integer id);
    AdminInfo getAdminInfoByName(String name);
    LoginAdminVo getLoginAdminVo(String name);
    Integer getTotalNum(String query);
    String loginAdmin(String username, String password, String ip);
    List<AdminInfo> getAllAdmin();
    List<AdminInfo> getAdminByPage(String query, Integer pageNum, Integer pageSize);
    Integer createAdmin(AdminInfo adminInfo);
    Integer updateAdmin(AdminInfo adminInfo);
    Integer updateAdminLogin(AdminLogin adminLogin);
    Integer deleteAdminById(Integer account);
    AdminLogin getAdminLoginByName(String name);
}
