package com.example.server.dao;

import com.example.server.model.entity.Role;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface RoleDao {

    @Select("SELECT * FROM role")
    public List<Role> getRoleList();

    @Select("SELECT * FROM role WHERE role.role_id = #{roleId}")
    public Role getRoleById(Integer roleId);



    @Select("SELECT r.* FROM role r INNER JOIN admin_info ai ON r.role_id = ai.role_id WHERE ai.admin_id = #{adminId}")
    public Role getRoleByAdminId(Integer adminId);

    @Insert({"INSERT INTO",
            "role(role_name, role_code, role_desc)",
            "VALUES(#{roleName}, #{roleCode}, #{roleDesc})"
    })
    @Options(useGeneratedKeys = true, keyProperty = "roleId")
    Integer createRole(Role role);

    @Update("UPDATE role SET role_name = #{roleName}, role_code = #{roleCode}, role_desc = #{roleDesc} WHERE role_id = #{roleId}")
    Integer updateRole(Role role);

    @Delete("DELETE FROM role WHERE role_id = #{roleId}")
    Integer deleteRoleById(Integer roleId);

    @Select("SELECT role.role_name FROM role WHERE role_id = #{roleId}")
    String getRoleNameById(Integer roleId);
}
