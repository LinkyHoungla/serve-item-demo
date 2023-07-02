package com.example.server.model;

import lombok.Data;

@Data
public class Role {
    private Integer roleId;
    private String roleName;
    private String roleCode;
    private String roleDesc;
}
