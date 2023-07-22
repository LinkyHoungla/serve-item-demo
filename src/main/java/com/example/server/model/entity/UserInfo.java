package com.example.server.model.entity;

import lombok.Data;

import java.util.Date;

@Data
public class UserInfo {
    private String uid;
    private String nickname;
    private String avatar;
    private String gender;
    private String age;
    private String birthday;
    private String location;
    private Date updateTime;
}
