package com.example.server.model.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Game {
    private Integer id;
    private Integer pid;
    private String type;
    private String name;
    private Date createTime;
    private Date updateTime;
}
