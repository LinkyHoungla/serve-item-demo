package com.example.server.model.param;

import lombok.Data;

@Data
public class LoginParam {
    private String username;
    private String password;

    public LoginParam(String username, String token) {
        this.username = username;
        this.password = token;
    }
}
