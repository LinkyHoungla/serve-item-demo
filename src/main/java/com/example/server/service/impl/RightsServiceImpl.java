package com.example.server.service.impl;

import com.example.server.dao.PagesDao;
import com.example.server.entity.Menus;
import com.example.server.entity.Pages;
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

    public List<Pages> getRightsTree() {
        List<Pages> pagesList = pagesDao.getParentRights();

        for(int i = 0; i < pagesList.size(); i ++) {
            pagesList.get(i).setChildPages(pagesDao.getChildRights(pagesList.get(i).getId()));
        }

        return pagesList;
    }

    @Override
    public List<Pages> getRightsList() {
        return pagesDao.getParentAllRights();
    }
}
