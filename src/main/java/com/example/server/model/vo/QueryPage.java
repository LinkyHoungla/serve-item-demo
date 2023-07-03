package com.example.server.model.vo;

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
}
