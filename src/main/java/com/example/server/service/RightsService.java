package com.example.server.service;

import com.example.server.model.Menus;
import com.example.server.model.Pages;
import io.swagger.models.auth.In;

import java.util.List;

public interface RightsService {
    public List<Menus> getMenus();
    public List<Menus> getMenusById(Integer roleId);
    public List<Pages> getRightsTree();
    public List<Pages> getRightsList();
}
