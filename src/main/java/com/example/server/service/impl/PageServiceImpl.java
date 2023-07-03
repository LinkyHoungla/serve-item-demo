package com.example.server.service.impl;

import com.example.server.dao.PageDao;
import com.example.server.model.entity.Page;
import com.example.server.model.vo.Menu;
import com.example.server.model.vo.PageTree;
import com.example.server.service.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PageServiceImpl implements PageService {
    @Autowired
    private PageDao pageDao;

    @Override
    public List<Page> getAllPages() {
        return pageDao.getAllPages();
    }

    @Override
    public List<PageTree> getPageTree() {
        List<PageTree> parents = pageDao.getParentPages();
        for (PageTree parent : parents) {
            parent.setChildren(pageDao.getChildPages(parent.getPageId()));
        }
        return parents;
    }

    @Override
    public List<Menu> getAdminMenu(String roleName) {
        List<Menu> parents = pageDao.getParentMenusByRoleName(roleName);
        for (Menu parent: parents) {
            parent.setChildren(pageDao.getChildMenusByRoleName(parent.getPageId(), roleName));
        }
        return parents;
    }
}
