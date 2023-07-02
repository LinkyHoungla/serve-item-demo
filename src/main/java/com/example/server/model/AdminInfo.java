package com.example.server.model;

import lombok.Data;

@Data
public class AdminInfo {
    private Integer account;
    private String username;
    private String role;

    public AdminInfo(Admin admin){
        this.account = admin.getAccount();
        this.role = admin.getRole();
        this.username = admin.getUsername();
    }
}
