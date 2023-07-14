package com.example.server.dao;

import com.example.server.model.entity.AdminInfo;
import com.example.server.model.entity.AdminLogin;
import org.apache.ibatis.annotations.*;

@Mapper
public interface AdminLoginDao {

    // 用户登录
    @Select("SELECT * FROM admin_login WHERE admin_name = #{adminName} AND password = #{password}")
    AdminLogin loginAdmin(String adminName, String password);

    // 添加用户登录信息
    @Insert("INSERT INTO admin_Login (admin_id, admin_name, password) " +
            "VALUES (#{adminId}, #{adminName}, #{password})")
    Integer addAdminLogin(AdminLogin adminLogin);

    // 更新用户登录信息
    @Update("UPDATE admin_login SET admin_name = #{adminName}, login_at = #{loginAt}, ip = #{ip} WHERE admin_id = #{adminId}")
    Integer updateAdminLogin(AdminLogin adminLogin);

    // 删除用户登录信息
    @Delete("DELETE FROM admin_login WHERE admin_id = #{account}")
    Integer deleteAdminLoginById(Integer account);
}
