package com.example.server.entity;

import lombok.Data;

@Data
public class Role {
    private Integer roleId;
    private String roleName;
    private String roleCode;
    private String roleDesc;
}
