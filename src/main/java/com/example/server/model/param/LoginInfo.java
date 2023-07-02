package com.example.server.model.param;

import lombok.Data;

@Data
public class LoginInfo {
    private String username;
    private String password;

    public LoginInfo(String username, String token) {
        this.username = username;
        this.password = token;
    }
}
