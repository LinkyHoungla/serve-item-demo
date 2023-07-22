package com.example.server.model.entity;

import lombok.Data;

import java.util.Date;

@Data
public class UserLogin {
    private String uid;
    private String username;
    private String password;
    private String ip;
    private Date loginTime;
}
