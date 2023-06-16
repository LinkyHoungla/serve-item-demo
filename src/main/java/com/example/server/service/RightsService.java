package com.example.server.service;

import com.example.server.entity.Menus;
import com.example.server.entity.Pages;

import java.util.List;

public interface RightsService {
    public List<Menus> getMenus();
    public List<Pages> getRightsTree();
    public List<Pages> getRightsList();
}
