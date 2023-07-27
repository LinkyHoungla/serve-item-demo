package com.example.server.model.entity;

import lombok.Data;

import java.util.Date;

@Data
public class ServiceType {
    private Integer id;
    private String type;
    private String name;
    private String gender;
    private Date createTime;
    private Date updateTime;
}
