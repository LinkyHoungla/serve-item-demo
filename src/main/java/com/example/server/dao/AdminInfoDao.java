package com.example.server.dao;

import com.example.server.model.entity.AdminInfo;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AdminInfoDao {
    @Select("SELECT * FROM admin_info WHERE admin_id = #{username}")
    AdminInfo getAdminInfoByName(String username);

    @Select("SELECT * FROM admins")
    List<AdminInfo> getAllAdmins();

    @Select("SELECT * FROM admins WHERE account = #{account}")
    AdminInfo getAdminById(Integer account);

    // 动态分页查询
    @Select({
            "<script>",
            "SELECT * FROM admin_info",
            "WHERE 1 = 1",
            "<if test='query != null'>",
            "AND full_name LIKE CONCAT('%', #{query}, '%')",
            "</if>",
            "</script>"
    })
    Page<AdminInfo> findAdminsByPage(String query);

    // 动态分页查询总量
    @Select({
            "<script>",
            "SELECT COUNT(*) FROM admin_info",
            "WHERE 1 = 1",
            "<if test='query != null'>",
            "AND full_name LIKE CONCAT('%', #{query}, '%')",
            "</if>",
            "</script>"
    })
    int getTotalNum(@Param("query") String query);

    @Insert({"INSERT INTO",
            "admins(username, password, role, create_at)",
            "VALUES(#{username}, #{password}, #{role}, #{createAt})"
    })
    @Options(useGeneratedKeys = true, keyProperty = "account")
    Integer createAdmin(AdminInfo adminInfo);

    @Update("UPDATE admins SET username = #{username}, role = #{role} WHERE account = #{account}")
    Integer updateAdmin(AdminInfo adminInfo);

    @Delete("DELETE FROM admins WHERE account = #{account}")
    Integer deleteAdminById(Integer account);
}
