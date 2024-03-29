package com.example.server.model.entity;

import com.example.server.model.param.AdminParam;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class AdminInfo {
    private Integer adminId;
    private String fullName;
    private Integer roleId;
    private String avatar;
    private Integer status;
    private Date createAt;
    private Date updateAt;

    public AdminInfo(AdminParam adminParam){
        this.adminId = adminParam.getAdminId();
        this.fullName = adminParam.getFullName();
        this.roleId = adminParam.getRoleId();
        this.updateAt = new Date();
    }
}
