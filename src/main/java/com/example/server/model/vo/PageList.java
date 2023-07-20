package com.example.server.model.vo;

import lombok.Data;

import java.util.List;

@Data
public class PageList {
    private Integer pageId;
    private String name;
    private String path;
    private Integer level;
    private Integer parentId;
    private List<PageList> children;
}
