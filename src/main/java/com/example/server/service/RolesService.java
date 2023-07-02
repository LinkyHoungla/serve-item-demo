package com.example.server.service;

import com.example.server.model.Role;

import java.util.List;

public interface RolesService {
    public List<Role> getAllRoles();

    Integer createRole(Role role);
    Integer updateRole(Role role);
    Integer deleteRoleById(Integer roleId);
}
