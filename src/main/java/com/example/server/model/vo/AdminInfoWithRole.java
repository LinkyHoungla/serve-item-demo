package com.example.server.model.vo;

import com.example.server.model.entity.Role;
import lombok.Data;

import java.util.Date;

@Data
public class AdminInfoWithRole {
    private Integer adminId;
    private String fullName;
    private Role role;
    private String avatar;
    private Integer status;
    private Date createAt;
    private Date updateAt;
}
