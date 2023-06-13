package com.example.server.entity;

import lombok.Data;

import java.util.List;

@Data
public class Rights {
    private Integer id;
    private Integer parentId;
    private String name;
    private String path;
    private Integer level;
    private List<Rights> childRights;
}
