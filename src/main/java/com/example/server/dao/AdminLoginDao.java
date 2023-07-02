package com.example.server.dao;

import com.example.server.model.entity.AdminInfo;
import com.example.server.model.entity.AdminLogin;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface AdminLoginDao {

    // 用户登录
    @Select("SELECT * FROM admin_login where admin_name = #{adminName} and password = #{password}")
    public AdminLogin loginAdmin(String adminName, String password);

    @Update("UPDATE admin_login SET admin_name = #{adminName}, login_at = #{loginAt}, ip = #{ip} WHERE admin_id = #{adminId}")
    Integer updateAdminLogin(AdminLogin adminLogin);

    @Select("SELECT * FROM admin_login where admin_name = #{adminName}")
    public AdminLogin getAdminLoginByName(String adminName);
}
