package com.example.server.dao;

import com.example.server.entity.Admin;
import com.example.server.entity.Role;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface RoleDao {

    @Select("SELECT * FROM roles")
    public List<Role> getAllRoles();

    @Insert({"INSERT INTO",
            "roles(role_name, role_code, role_desc)",
            "VALUES(#{roleName}, #{roleCode}, #{roleDesc})"
    })
    @Options(useGeneratedKeys = true, keyProperty = "roleId")
    Integer createRole(Role role);

    @Update("UPDATE roles SET role_name = #{roleName}, role_code = #{roleCode}, role_desc = #{roleDesc} WHERE role_id = #{roleId}")
    Integer updateRole(Role role);

    @Delete("DELETE FROM roles WHERE role_id = #{roleId}")
    Integer deleteRoleById(Integer roleId);
}
