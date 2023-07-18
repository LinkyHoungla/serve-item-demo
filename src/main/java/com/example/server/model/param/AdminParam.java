package com.example.server.model.param;

import lombok.Data;

@Data
public class AdminParam {
    private Integer adminId;
    private String adminName;
    private String fullName;
    private Integer roleId;
}
