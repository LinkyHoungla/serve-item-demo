package com.example.server.service;

import com.example.server.model.entity.AdminInfo;
import com.example.server.model.entity.AdminLogin;
import com.example.server.model.param.AdminParam;
import com.example.server.model.vo.AdminInfoWithRole;
import com.example.server.model.vo.LoginAdminVo;
import com.github.pagehelper.PageInfo;

public interface AdminService {
    AdminInfo getAdminInfoById(Integer id);
    LoginAdminVo getLoginAdminVo(Integer id);
    AdminLogin getAdminLoginByName(String name);
    String loginAdmin(String username, String password, String ip);
    PageInfo<AdminInfoWithRole> getAdminsByPage(String query, Integer pageNum, Integer pageSize);


    Integer addAdminInfo(AdminParam adminParam);
    Integer updateAdminInfo(AdminParam adminParam);
    Integer updateAvatar(Integer adminId, String filepath);
    Integer deleteAdminInfoById(Integer account);

}
