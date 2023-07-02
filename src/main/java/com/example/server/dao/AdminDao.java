package com.example.server.dao;

import com.example.server.model.Admin;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AdminDao {

    @Select("SELECT * FROM admins where username = #{username} and password = #{password}")
    public Admin getAdminByLogin(String username, String password);

    @Select("SELECT * FROM admins")
    List<Admin> getAllAdmins();

//    动态分页查询
//    @Select("SELECT * FROM admins LIMIT #{pageNum}, #{pageSize}")
//    List<Admin> getAdminByPage(String query, Integer pageNum, Integer pageSize);
    @Select({
            "<script>",
            "SELECT * FROM admins",
            "WHERE 1 = 1",
            "<if test='query != null'>",
            "AND username LIKE CONCAT('%', #{query}, '%')",
            "</if>",
            "LIMIT #{offset}, #{pageSize}",
            "</script>"
    })
    List<Admin> getAdminByPage(
            @Param("query") String query,
            @Param("offset") int offset,
            @Param("pageSize") int pageSize
    );

    @Select("SELECT * FROM admins WHERE account = #{account}")
    Admin getAdminById(Integer account);

    @Select("SELECT * FROM admins WHERE username = #{username}")
    Admin getAdminByName(String username);

    //  动态分页查询重量
    //  @Select("SELECT COUNT(*) FROM admins")
    //  Integer getTotalNum();
    @Select({
            "<script>",
            "SELECT COUNT(*) FROM admins",
            "WHERE 1 = 1",
            "<if test='query != null'>",
            "AND username LIKE CONCAT('%', #{query}, '%')",
            "</if>",
            "</script>"
    })
    int getTotalNum(@Param("query") String query);

    @Insert({"INSERT INTO",
            "admins(username, password, role, create_at)",
            "VALUES(#{username}, #{password}, #{role}, #{createAt})"
    })
    @Options(useGeneratedKeys = true, keyProperty = "account")
    Integer createAdmin(Admin admin);

    @Update("UPDATE admins SET username = #{username}, role = #{role} WHERE account = #{account}")
    Integer updateAdmin(Admin admin);

    @Delete("DELETE FROM admins WHERE account = #{account}")
    Integer deleteAdminById(Integer account);
}
