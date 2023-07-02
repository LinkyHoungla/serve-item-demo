package com.example.server.model;

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
