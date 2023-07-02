package com.example.server.service;

import com.example.server.model.entity.Role;

import java.util.List;

public interface RoleService {
    public List<Role> getAllRoles();

    public Role getRoleByAdminId(Integer adminId);

    Integer createRole(Role role);
    Integer updateRole(Role role);
    Integer deleteRoleById(Integer roleId);
}
