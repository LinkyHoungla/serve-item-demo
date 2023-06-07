package com.example.server.service;

import com.example.server.dao.MenusDao;
import com.example.server.entity.Menus;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenusService {

    @Autowired
    private MenusDao menusDao;

    public List<Menus> getMenus() {
        List<Menus> menusList = menusDao.getParentMenus();

        for(int i = 0 ; i < menusList.size(); i ++) {
            menusList.get(i).setChildMenus(menusDao.getChildMenus(menusList.get(i).getMenusId()));
        }

        return menusList;
    }
}
