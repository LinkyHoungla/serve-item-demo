package com.example.server.model.entity;

import lombok.Data;

@Data
public class Right {
    private Integer pageId;
    private Integer parentId;
    private String name;
    private String path;
    private String icon;
    private Integer level;
}
