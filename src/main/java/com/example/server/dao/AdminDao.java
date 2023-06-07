package com.example.server.dao;

import com.example.server.entity.Admin;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AdminDao {

    @Select("SELECT * FROM admins where username = #{username} and password = #{password}")
    public Admin getAdminByLogin(String username, String password);

    @Select("SELECT * FROM admins")
    List<Admin> getAllAdmins();

    @Select("SELECT * FROM admins WHERE account = #{account}")
    Admin getAdminById(Integer account);

    @Insert("INSERT INTO admins(name, email) VALUES(#{name}, #{email})")
    @Options(useGeneratedKeys = true, keyProperty = "account")
    void createAdmin(Admin admin);

    @Update("UPDATE admins SET username = #{username}, password = #{password} WHERE account = #{account}")
    void updateAdmin(Admin admin);

    @Delete("DELETE FROM admins WHERE account = #{account}")
    void deleteAdmin(Integer account);
}
