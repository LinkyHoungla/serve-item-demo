package com.example.server.model.entity;

import lombok.Data;

import java.util.Date;

@Data
public class AdminInfo {
    private Integer adminId;
    private String fullName;
    private Integer roleId;
    private String avatar;
    private Integer status;
    private Date createAt;
    private Date updateAt;
}
