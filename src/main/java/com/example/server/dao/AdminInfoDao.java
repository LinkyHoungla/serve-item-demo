package com.example.server.dao;

import com.example.server.model.entity.AdminInfo;
import com.example.server.model.entity.AdminLogin;
import com.example.server.model.param.AdminParam;
import com.example.server.model.vo.AdminInfoWithRole;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

@Mapper
public interface AdminInfoDao {
    @Select("SELECT * FROM admin_info WHERE admin_id = #{uid}")
    AdminInfo getAdminInfoById(Integer uid);

    @Select("SELECT * FROM admins")
    List<AdminInfo> getAllAdmins();

    @Select("SELECT ai.* FROM admin_info ai JOIN admin_login al ON al.admin_id = ai.admin_id WHERE al.admin_name = #{username}")
    AdminInfo getAdminInfoByName(String username);

    // 查找带Role的Admin
    @Select({
            "<script>",
            "SELECT ai.*, r.* ",
            "FROM admin_info ai ",
            "INNER JOIN role r ON ai.role_id = r.role_id ",
            "WHERE 1 = 1",
            "<if test='query != null'>",
            "AND full_name LIKE CONCAT('%', #{query}, '%')",
            "</if>",
            "</script>"
            })
    @Results({
            @Result(property = "role", column = "role_id",
                    one = @One(select = "com.example.server.dao.RoleDao.getRoleById"))
    })
    Page<AdminInfoWithRole> findAdminInfoWithRoleByPage(String query);

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

    @Insert("INSERT INTO admin_info (full_name, role_id, avatar, status, create_at, update_at) " +
            "VALUES (#{fullName}, #{roleId}, #{avatar}, #{status}, #{createAt}, #{updateAt})")
    @Options(useGeneratedKeys = true, keyProperty = "adminId")
    Integer addAdminInfo(AdminInfo adminInfo);

    @Update("UPDATE admin_info " +
            "SET full_name = #{fullName}, role_Id = #{roleId}, avatar = #{avatar}, status = #{status} " +
            "WHERE admin_id = #{adminId}")
    Integer updateAdminInfo(AdminParam adminParam);

    @Delete("DELETE FROM admin_info WHERE admin_id = #{account}")
    Integer deleteAdminInfoById(Integer account);
}
