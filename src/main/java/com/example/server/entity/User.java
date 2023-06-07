package com.example.server.entity;

import lombok.Data;

@Data
public class User {
    private String username;
    private Integer uid;
    private String password;
    private String mobile;
    private String email;
    private String token;
}
