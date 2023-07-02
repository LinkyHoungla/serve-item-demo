package com.example.server.service;

import com.example.server.model.Menus;
import com.example.server.model.entity.Page;

import java.util.List;

public interface RightsService {
    public List<Menus> getMenus();
    public List<Menus> getMenusById(Integer roleId);
    public List<Page> getRightsTree();
    public List<Page> getRightsList();
}
