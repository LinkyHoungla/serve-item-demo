package com.example.server.entity;

import lombok.Data;

import java.util.List;

@Data
public class QueryPage<T> {
    private Integer totalNum;
    private List<T> array;

    public QueryPage(Integer totalNum, List<T> array) {
        this.totalNum = totalNum;
        this.array = array;
    }

    // 静态方法，返回包含登录信息的token
    public static <T> QueryPage success(Integer totalNum, List<T> array) {
        return new QueryPage(totalNum, array);
    }
}
