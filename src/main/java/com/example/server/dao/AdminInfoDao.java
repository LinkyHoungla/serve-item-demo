package com.example.server.dao;

import com.example.server.model.entity.AdminInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AdminInfoDao {
    @Select("SELECT * FROM admin_info WHERE admin_id = #{username}")
    AdminInfo getAdminInfoByName(String username);

    @Select("SELECT * FROM admins")
    List<AdminInfo> getAllAdmins();

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
    List<AdminInfo> getAdminByPage(
            @Param("query") String query,
            @Param("offset") int offset,
            @Param("pageSize") int pageSize
    );

    @Select("SELECT * FROM admins WHERE account = #{account}")
    AdminInfo getAdminById(Integer account);


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
    Integer createAdmin(AdminInfo adminInfo);

    @Update("UPDATE admins SET username = #{username}, role = #{role} WHERE account = #{account}")
    Integer updateAdmin(AdminInfo adminInfo);

    @Delete("DELETE FROM admins WHERE account = #{account}")
    Integer deleteAdminById(Integer account);
}
