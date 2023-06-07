package com.example.server.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Admin {
    private Integer account;
    private String username;
    private String password;
    private String role;
    private Date createAt;
    private Date loginAt;
    private Date logoutAt;
}
