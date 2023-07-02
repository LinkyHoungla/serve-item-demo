package com.example.server.model.entity;

import lombok.Data;

@Data
public class Role {
    private Integer roleId;
    private String roleCode;
    private String roleName;
    private String roleDesc;
}
