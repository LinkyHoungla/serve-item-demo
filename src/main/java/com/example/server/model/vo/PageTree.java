package com.example.server.model.vo;

import lombok.Data;

import java.util.List;

@Data
public class PageTree {
    private Integer pageId;
    private String name;
    private Integer parentId;
    private String path;
    private Integer level;
    private List<PageTree> children;
}
