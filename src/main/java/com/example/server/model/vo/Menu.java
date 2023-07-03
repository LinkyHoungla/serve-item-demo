package com.example.server.model.vo;

import lombok.Data;

import java.util.List;

@Data
public class Menu {
    private Integer pageId;
    private String name;
    private String path;
    private String icon;
    private Integer parentId;
    private List<Menu> children;
}
