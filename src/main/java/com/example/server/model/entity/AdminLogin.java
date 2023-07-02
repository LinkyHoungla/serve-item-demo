package com.example.server.model.entity;

import lombok.Data;

import java.util.Date;

@Data
public class AdminLogin {
    private Integer adminId;
    private String adminName;
    private String password;
    private Date loginAt;
    private String ip;
}
