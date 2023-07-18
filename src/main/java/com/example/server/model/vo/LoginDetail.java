package com.example.server.model.vo;

import lombok.Data;

@Data
public class LoginDetail {
    private Integer uid;
    private String username;
    private Integer roleId;
    private String ip;
}
