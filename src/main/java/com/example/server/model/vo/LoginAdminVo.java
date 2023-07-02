package com.example.server.model.vo;

import com.example.server.model.entity.AdminInfo;
import com.example.server.model.entity.Role;
import lombok.Data;

@Data
public class LoginAdminVo {
    private String name;
    private String roleName;
    private String avatar;

    public LoginAdminVo(AdminInfo adminInfo, Role role) {
        this.name = adminInfo.getFullName();
        this.roleName = role.getRoleName();
        this.avatar = adminInfo.getAvatar();
    }
}
