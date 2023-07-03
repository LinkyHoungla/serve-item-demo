package com.example.server.model.vo;

import com.example.server.model.entity.Page;
import lombok.Data;

import java.util.List;

@Data
public class PageTree {
    private Integer pageId;
    private String name;
    private Integer parentId;
    private List<PageTree> children;
}
