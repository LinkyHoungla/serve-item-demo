package com.example.server.model.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Order {
    private String oid;
    private String sid;
    private String uid;
    private Float totalPrice;
    private Date startTime;
    private Integer serveDuration;
    private Date endTime;
    private Integer status;
    private Date createTime;
    private Date updateTime;
}
