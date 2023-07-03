package com.example.server.service;

import com.example.server.model.entity.AdminInfo;
import com.example.server.model.entity.AdminLogin;
import com.example.server.model.param.AdminParam;
import com.example.server.model.vo.LoginAdminVo;
import com.example.server.model.vo.QueryPage;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface AdminService {
    AdminInfo getAdminById(Integer id);
    AdminInfo getAdminInfoByName(String name);
    LoginAdminVo getLoginAdminVo(String name);
    String loginAdmin(String username, String password, String ip);
    List<AdminInfo> getAllAdmin();
    PageInfo<AdminInfo> getAdminsByPage(String query, Integer pageNum, Integer pageSize);
    Integer addAdmin(AdminParam adminParam);
    Integer deleteAdminById(Integer account);
    AdminLogin getAdminLoginByName(String name);
}
