package com.example.server.service.impl;

import com.example.server.dao.RoleDao;
import com.example.server.model.entity.Role;
import com.example.server.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleDao roleDao;
    @Override
    public List<Role> getRoleList() {
        return roleDao.getRoleList();
    }
    @Override
    public Role getRoleByAdminId(Integer adminId) {
        return roleDao.getRoleByAdminId(adminId);
    }
    @Override
    public String getRoleCodeByAdminId(Integer adminId) {
        return roleDao.getRoleCodeByAdminId(adminId);
    }

    @Override
    public String getRoleNameById(Integer roleId) {
        return roleDao.getRoleNameById(roleId);
    }

    @Override
    public Integer createRole(Role role) {
        return roleDao.createRole(role);
    }
    @Override
    public Integer updateRole(Role role) {
        return roleDao.updateRole(role);
    }
    @Override
    public Integer deleteRoleById(Integer roleId) {
        return roleDao.deleteRoleById(roleId);
    }
}
