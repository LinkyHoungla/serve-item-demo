package com.example.server.service;


import com.example.server.model.entity.Right;
import com.example.server.model.vo.Menu;
import com.example.server.model.vo.PageTree;

import java.util.List;

public interface RightService {
    public List<Right> getAllPages();
    public List<PageTree> getPageTree();
    public List<Menu> getAdminMenu(String roleName);
}
