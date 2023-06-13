package com.example.server.service;

import com.example.server.entity.Menus;
import com.example.server.entity.Rights;

import java.util.List;

public interface RightsService {
    public List<Menus> getMenus();
    public List<Rights> getRightsTree();
    public List<Rights> getRightsList();
}
