package com.example.server.service.impl;

import com.example.server.dao.RightsDao;
import com.example.server.entity.Menus;
import com.example.server.entity.Rights;
import com.example.server.service.RightsService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RightsServiceImpl implements RightsService {

    @Autowired
    private RightsDao rightsDao;

    public List<Menus> getMenus() {
        List<Menus> menusList = rightsDao.getParentMenus();

        for(int i = 0 ; i < menusList.size(); i ++) {
            menusList.get(i).setChildMenus(rightsDao.getChildMenus(menusList.get(i).getId()));
        }

        return menusList;
    }

    public List<Rights> getRightsTree() {
        List<Rights> rightsList = rightsDao.getParentRights();

        for(int i = 0 ; i < rightsList.size(); i ++) {
            rightsList.get(i).setChildRights(rightsDao.getChildRights(rightsList.get(i).getId()));
        }

        return rightsList;
    }

    @Override
    public List<Rights> getRightsList() {
        return rightsDao.getParentAllRights();
    }
}
