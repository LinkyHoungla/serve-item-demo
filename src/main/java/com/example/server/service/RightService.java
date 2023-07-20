package com.example.server.service;


import com.example.server.model.param.PageParam;
import com.example.server.model.vo.Menu;
import com.example.server.model.vo.PageList;
import com.example.server.model.vo.PageTree;
import com.github.pagehelper.PageInfo;
import io.swagger.models.auth.In;

import java.util.List;

public interface RightService {
    PageInfo<PageList> getPageList(String query, Integer pageNum, Integer pageSize);
    PageInfo<PageTree> getPageTreeByPage(String query, Integer pageNum, Integer pageSize);
    List<PageTree> getPageTree(Integer level);
    List<Menu> getAdminMenu(Integer roleId);
    List<PageTree> getRoleRights(Integer roleId);
    List<Integer> getRightsIdList(Integer roleId);
    Integer addRights(Integer roleId, List<Integer> rights);
    Integer addPage(PageParam param);
    Integer deleteRight(Integer pageId, Integer roleId);
    Integer deletePage(Integer pageId);
    Integer updatePage(PageParam param, Integer pageId);
}
