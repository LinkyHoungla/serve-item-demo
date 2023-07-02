package com.example.server.service.impl;

import com.example.server.dao.PagesDao;
import com.example.server.model.Menus;
import com.example.server.model.entity.Page;
import com.example.server.service.RightsService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RightsServiceImpl implements RightsService {

    @Autowired
    private PagesDao pagesDao;

    public List<Menus> getMenus() {
        List<Menus> menusList = pagesDao.getParentMenus();

        for(int i = 0 ; i < menusList.size(); i ++) {
            menusList.get(i).setChildMenus(pagesDao.getChildMenus(menusList.get(i).getId()));
        }

        return menusList;
    }

    @Override
    public List<Menus> getMenusById(Integer roleId) {
        List<Menus> menusList = pagesDao.getParentMenusByRoleId(roleId);

        for(int i = 0 ; i < menusList.size(); i ++) {
            menusList.get(i).setChildMenus(pagesDao.getChildMenusByRoleId(menusList.get(i).getId(), roleId));
        }

        return menusList;
    }

    public List<Page> getRightsTree() {
        List<Page> pageList = pagesDao.getParentRights();

        // for(int i = 0; i < pageList.size(); i ++) {
        //     pageList.get(i).setChildPages(pagesDao.getChildRights(pageList.get(i).getId()));
        // }

        return pageList;
    }

    @Override
    public List<Page> getRightsList() {
        return pagesDao.getAllRights();
    }
}
