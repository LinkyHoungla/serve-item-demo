package com.example.server.entity;

import lombok.Data;

import java.util.List;

@Data
public class PageInfo<T> {
    private Integer totalNum;
    private List<T> array;

    public PageInfo(Integer totalNum, List<T> array) {
        this.totalNum = totalNum;
        this.array = array;
    }

    // 静态方法，返回包含登录信息的token
    public static <T> PageInfo success(Integer totalNum, List<T> array) {
        return new PageInfo(totalNum, array);
    }
}
