package com.example.server.model.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Companion {
    private String cid;
    private String uid;
    private String sid;
    private String signature;
    private Integer status;
    private Date createTime;
    private Date updateTime;
}
