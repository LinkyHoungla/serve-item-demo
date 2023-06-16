package com.example.server.entity;

import lombok.Data;

import java.util.List;

@Data
public class Pages {
    private Integer id;
    private Integer parentId;
    private String name;
    private String path;
    private Integer level;
    private List<Pages> childPages;
}
