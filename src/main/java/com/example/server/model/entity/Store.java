package com.example.server.model.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Store {
    private String storeId;
    private String storeName;
    private String storeAvatar;
    private String storeDesc;
    private String ownerId;
    private String contactName;
    private String contactPhone;
    private Integer status;
    private Date createTime;
    private Date updateTime;
}
