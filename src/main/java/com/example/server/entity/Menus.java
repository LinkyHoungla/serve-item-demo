package com.example.server.entity;

import lombok.Data;

import java.util.List;

@Data
public class Menus {
    private Integer menusId;
    private Integer parentId;
    private String menusName;
    private String menusPath;
    private String menusIcon;
    private List<Menus> childMenus;
}
