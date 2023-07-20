package com.example.server.service.impl;

import com.example.server.dao.RightDao;
import com.example.server.model.param.PageParam;
import com.example.server.model.vo.AdminInfoWithRole;
import com.example.server.model.vo.Menu;
import com.example.server.model.vo.PageList;
import com.example.server.model.vo.PageTree;
import com.example.server.service.RightService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RightServiceImpl implements RightService {
    @Autowired
    private RightDao rightDao;

    @Override
    public PageInfo<PageList> getPageList(String query, Integer pageNum, Integer pageSize) {
        // 使用PageHelper进行分页设置
        PageHelper.startPage(pageNum, pageSize);
        // 调用分页查询的方法
        Page<PageList> rightPage = rightDao.getPageList();
        // 封装分页结果为PageInfo对象
        return new PageInfo<>(rightPage);
    }

    @Override
    public List<PageTree> getPageTree() {
        List<PageTree> parents = rightDao.getParentPages();
        for (PageTree parent : parents) {
            List<PageTree> sons = rightDao.getChildPages(parent.getPageId());
            parent.setChildren(sons);
            for (PageTree son: sons) {
                son.setChildren(rightDao.getChildPages(son.getPageId()));
            }
        }
        return parents;
    }

    @Override
    public List<Menu> getAdminMenu(Integer roleId) {
        List<Menu> parents = rightDao.getParentMenusByRoleId(roleId);
        for (Menu parent: parents) {
            parent.setChildren(rightDao.getChildMenusByRoleId(parent.getPageId(), roleId));
        }
        return parents;
    }

    @Override
    public List<PageTree> getRoleRights(Integer roleId) {
        List<PageTree> parents = rightDao.getParentRightsByRoleId(roleId);
        for (PageTree parent : parents) {
            List<PageTree> sons = rightDao.getChildRightsByRoleId(parent.getPageId(), roleId);
            parent.setChildren(sons);
            for (PageTree son: sons) {
                son.setChildren(rightDao.getChildRightsByRoleId(son.getPageId(), roleId));
            }
        }
        return parents;
    }

    @Override
    public Integer addPage(PageParam param) {
        return rightDao.addPage(param);
    }

    @Override
    public Integer deleteRight(Integer pageId, Integer roleId) {
        return rightDao.deleteRight(pageId, roleId);
    }

    @Override
    public Integer deletePage(Integer pageId) {
        return rightDao.deletePage(pageId);
    }

    @Override
    public Integer updatePage(PageParam param, Integer pageId) {
        return rightDao.updatePage(param, pageId);
    }

    @Override
    public List<Integer> getRightsIdList(Integer roleId) {
        return rightDao.getRightsIdList(roleId);
    }

    @Override
    @Transactional
    public Integer addRights(Integer roleId, List<Integer> rights) {
        return rightDao.deleteAllRight(roleId) + rightDao.addRights(roleId, rights);
    }
}
