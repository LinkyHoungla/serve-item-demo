package com.example.server.model.entity;

import lombok.Data;

import java.util.Date;

@Data
public class UserBasic {
    private String uid;
    private String wxid;
    private String walletId;
    private String phone;
    private Integer status;
    private Date createTime;
    private Date updateTime;
}
