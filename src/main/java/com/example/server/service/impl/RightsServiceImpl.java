package com.example.server.service.impl;

import com.example.server.dao.PageDao;
import com.example.server.model.Menus;
import com.example.server.model.entity.Page;
import com.example.server.service.RightsService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RightsServiceImpl implements RightsService {

    @Autowired
    private PageDao pageDao;

    public List<Menus> getMenus() {
        // List<Menus> menusList = pageDao.getParentMenus();
        //
        // for(int i = 0 ; i < menusList.size(); i ++) {
        //     menusList.get(i).setChildMenus(pageDao.getChildMenus(menusList.get(i).getId()));
        // }
        //
        // return menusList;
        return null;
    }

    @Override
    public List<Menus> getMenusById(Integer roleId) {
        // List<Menus> menusList = pageDao.getParentMenusByRoleId(roleId);

        // for(int i = 0 ; i < menusList.size(); i ++) {
        //     // menusList.get(i).setChildMenus(pageDao.getChildMenusByRoleId(menusList.get(i).getId(), roleId));
        // }

        return null;
    }

    public List<Page> getRightsTree() {
        // List<Page> pageList = pageDao.getParentRights();

        // for(int i = 0; i < pageList.size(); i ++) {
        //     pageList.get(i).setChildPages(pagesDao.getChildRights(pageList.get(i).getId()));
        // }

        return null;
    }

    @Override
    public List<Page> getRightsList() {
        // return pageDao.getAllRights();
        return null;
    }
}
