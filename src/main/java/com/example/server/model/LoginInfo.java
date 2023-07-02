package com.example.server.model;

import lombok.Data;

@Data
public class LoginInfo {
    private String username;
    // 登录时用于接收密码，返回用于存储token
    private String password;

    public LoginInfo(String username, String token) {
        this.username = username;
        this.password = token;
    }

    // 静态方法，返回包含登录信息的token
    public static LoginInfo success(String username, String token) {
        return new LoginInfo(username, token);
    }
}
