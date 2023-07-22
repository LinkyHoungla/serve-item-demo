package com.example.server.model.vo;

import com.example.server.model.entity.UserBasic;
import com.example.server.model.entity.UserInfo;
import com.example.server.model.entity.UserLogin;
import lombok.Data;

import java.util.Date;

@Data
public class UserInfoVo {
    private Integer uid;
    private Integer wxid;
    private Integer walletId;
    private Integer phone;
    private Integer status;
    private Date createTime;
    private Date updateTime;
    private UserInfo userInfo;
    private UserLogin login;
}
