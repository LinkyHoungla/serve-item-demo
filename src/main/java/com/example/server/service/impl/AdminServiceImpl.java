package com.example.server.service.impl;

import com.example.server.constant.ApiError;
import com.example.server.dao.AdminInfoDao;
import com.example.server.dao.AdminLoginDao;
import com.example.server.exception.ApiException;
import com.example.server.model.entity.AdminInfo;
import com.example.server.model.entity.AdminLogin;
import com.example.server.model.entity.Role;
import com.example.server.model.vo.LoginAdminVo;
import com.example.server.model.vo.LoginDetail;
import com.example.server.service.AdminService;
import com.example.server.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminInfoDao adminInfoDao;
    @Autowired
    private AdminLoginDao adminLoginDao;
    @Autowired RoleServiceImpl roleService;

    @Override
    public AdminInfo getAdminById(Integer account) {
        return adminInfoDao.getAdminById(account);
    }

    @Override
    public AdminInfo getAdminInfoByName(String name) {
        return adminInfoDao.getAdminInfoByName(name);
    }

    @Override
    public LoginAdminVo getLoginAdminVo(String name) {
        AdminInfo adminInfo = getAdminInfoByName(name);
        if (adminInfo == null) throw new ApiException(ApiError.E401);
        Role role = roleService.getRoleByAdminId(adminInfo.getAdminId());
        if (role == null) throw new ApiException(ApiError.E401);
        return new LoginAdminVo(adminInfo, role);
    }

    private Integer login(AdminLogin adminLogin){
        return adminLoginDao.updateAdminLogin(adminLogin);
    }

    @Override
    public Integer getTotalNum(String query) {
        return adminInfoDao.getTotalNum(query);
    }

    @Override
    public String loginAdmin(String username, String password, String ip) {
        AdminLogin adminLogin = adminLoginDao.loginAdmin(username, password);
        if(adminLogin == null) throw new ApiException(ApiError.E401);
        adminLogin.setIp(ip);
        adminLogin.setLoginAt(new Date());
        if(login(adminLogin) <= 0) throw new ApiException(ApiError.E401);

        LoginDetail loginDetail = new LoginDetail();
        loginDetail.setUid(adminLogin.getAdminId());
        loginDetail.setUsername(adminLogin.getAdminName());
        loginDetail.setIp(ip);
        loginDetail.setRole(roleService.getRoleCodeByAdminId(loginDetail.getUid()));

        // System.out.println(loginDetail);

        return JwtUtil.generateToken(loginDetail);
    }

    @Override
    public List<AdminInfo> getAllAdmin() {
        return null;
    }

    @Override
    public List<AdminInfo> getAdminByPage(String query, Integer pageNum, Integer pageSize) {
         return adminInfoDao.getAdminByPage(query, pageNum, pageSize);
    }

    @Override
    public Integer createAdmin(AdminInfo adminInfo) {
       return adminInfoDao.createAdmin(adminInfo);
    }

    @Override
    public Integer updateAdmin(AdminInfo adminInfo) {
        return adminInfoDao.updateAdmin(adminInfo);
    }

    @Override
    public Integer updateAdminLogin(AdminLogin adminLogin) {
        return adminLoginDao.updateAdminLogin(adminLogin);
    }

    @Override
    public Integer deleteAdminById(Integer account) {
        return adminInfoDao.deleteAdminById(account);
    }

    @Override
    public AdminLogin getAdminLoginByName(String name) {
        return getAdminLoginByName(name);
    }
}
