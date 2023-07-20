package com.example.server.service.impl;

import com.example.server.constant.ApiError;
import com.example.server.dao.AdminInfoDao;
import com.example.server.dao.AdminLoginDao;
import com.example.server.exception.ApiException;
import com.example.server.model.entity.AdminInfo;
import com.example.server.model.entity.AdminLogin;
import com.example.server.model.entity.Role;
import com.example.server.model.param.AdminParam;
import com.example.server.model.vo.AdminInfoWithRole;
import com.example.server.model.vo.LoginAdminVo;
import com.example.server.model.vo.LoginDetail;
import com.example.server.service.AdminService;
import com.example.server.util.JwtUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdminInfoDao adminInfoDao;
    @Autowired
    private AdminLoginDao adminLoginDao;
    @Autowired
    private RoleServiceImpl roleService;

    @Override
    public AdminInfo getAdminInfoById(Integer uid) {
        return adminInfoDao.getAdminInfoById(uid);
    }

    @Override
    public LoginAdminVo getLoginAdminVo(Integer uid) {
        AdminInfo adminInfo = getAdminInfoById(uid);
        if (adminInfo == null) throw new ApiException(ApiError.E401);
        Role role = roleService.getRoleByAdminId(adminInfo.getAdminId());
        if (role == null) throw new ApiException(ApiError.E401);
        return new LoginAdminVo(adminInfo, role);
    }

    private Integer login(AdminLogin adminLogin){
        return adminLoginDao.updateAdminLogin(adminLogin);
    }

    @Override
    public String loginAdmin(String username, String password, String ip) {
        AdminLogin adminLogin = adminLoginDao.loginAdmin(username, password);
        if(adminLogin == null) throw new ApiException(ApiError.E404);
        adminLogin.setIp(ip);
        adminLogin.setLoginAt(new Date());
        if(login(adminLogin) <= 0) throw new ApiException(ApiError.E401);

        LoginDetail loginDetail = new LoginDetail();
        loginDetail.setUid(adminLogin.getAdminId());
        loginDetail.setUsername(adminLogin.getAdminName());
        loginDetail.setIp(ip);
        loginDetail.setRoleId(adminInfoDao.getRoleIdByAdminId(adminLogin.getAdminId()));

        return JwtUtil.generateToken(loginDetail);
    }


    @Override
    public PageInfo<AdminInfoWithRole> getAdminsByPage(String query, Integer pageNum, Integer pageSize) {
         // return new QueryPage<>(adminInfoDao.getTotalNum(query), adminInfoDao.getAdminsByPage(query, pageNum, pageSize));
        // 使用PageHelper进行分页设置
        PageHelper.startPage(pageNum, pageSize);
        // 调用分页查询的方法
        Page<AdminInfoWithRole> adminPage = adminInfoDao.findAdminInfoWithRoleByPage(query);
        // 封装分页结果为PageInfo对象
        return new PageInfo<>(adminPage);
    }

    @Override
    @Transactional
    public Integer addAdminInfo(AdminParam adminParam) {
        AdminInfo adminInfo = new AdminInfo(adminParam);
        adminInfo.setCreateAt(new Date());

        AdminLogin adminLogin = new AdminLogin();
        adminLogin.setAdminId(adminInfo.getAdminId());
        adminLogin.setAdminName(adminParam.getAdminName());
        adminLogin.setPassword("123456");

        return adminInfoDao.addAdminInfo(adminInfo) + adminLoginDao.addAdminLogin(adminLogin);
    }

    @Override
    public Integer updateAdminInfo(AdminParam adminParam) {
        AdminInfo adminInfo = new AdminInfo(adminParam);
        return adminInfoDao.updateAdminInfo(adminInfo);
    }

    @Override
    public void updateAvatar(Integer adminId, String filepath) {
        adminInfoDao.updateAvatar(adminId, filepath);
    }

    @Override
    @Transactional
    public Integer deleteAdminInfoById(Integer account) {
        adminLoginDao.deleteAdminLoginById(account);
        return adminInfoDao.deleteAdminInfoById(account);
    }

}
