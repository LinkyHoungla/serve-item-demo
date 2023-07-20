package com.example.server.model.param;


import lombok.Data;

@Data
public class PageParam {
    private Integer parentId;
    private String name;
    private String path;
    private Integer level;
}
