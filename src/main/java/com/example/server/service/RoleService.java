package com.example.server.service;

import com.example.server.model.entity.Role;

import java.util.List;

public interface RoleService {
    List<Role> getRoleList();
    Role getRoleByAdminId(Integer adminId);
    String getRoleNameById(Integer adminId);
    Integer createRole(Role role);
    Integer updateRole(Role role);
    Integer deleteRoleById(Integer roleId);
}
