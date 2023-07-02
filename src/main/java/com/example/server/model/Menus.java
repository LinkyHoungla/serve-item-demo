package com.example.server.model;

import lombok.Data;

import java.util.List;

@Data
public class Menus {
    private Integer id;
    private Integer parentId;
    private String name;
    private String path;
    private String icon;
    private List<Menus> childMenus;
}
