package com.example.server.model.vo;

import lombok.Data;

@Data
public class PageList {
    private Integer pageId;
    private String name;
    private String path;
    private Integer level;
}
