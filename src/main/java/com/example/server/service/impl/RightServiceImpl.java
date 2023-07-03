package com.example.server.service.impl;

import com.example.server.dao.RightDao;
import com.example.server.model.entity.Right;
import com.example.server.model.vo.Menu;
import com.example.server.model.vo.PageTree;
import com.example.server.service.RightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RightServiceImpl implements RightService {
    @Autowired
    private RightDao rightDao;

    @Override
    public List<Right> getAllPages() {
        return rightDao.getAllPages();
    }

    @Override
    public List<PageTree> getPageTree() {
        List<PageTree> parents = rightDao.getParentPages();
        for (PageTree parent : parents) {
            parent.setChildren(rightDao.getChildPages(parent.getPageId()));
        }
        return parents;
    }

    @Override
    public List<Menu> getAdminMenu(String roleName) {
        List<Menu> parents = rightDao.getParentMenusByRoleName(roleName);
        for (Menu parent: parents) {
            parent.setChildren(rightDao.getChildMenusByRoleName(parent.getPageId(), roleName));
        }
        return parents;
    }
}
