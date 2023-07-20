package com.example.server.service;


import com.example.server.model.vo.Menu;
import com.example.server.model.vo.PageList;
import com.example.server.model.vo.PageTree;
import io.swagger.models.auth.In;

import java.util.List;

public interface RightService {
    List<PageList> getPageList();
    List<PageTree> getPageTree();
    List<Menu> getAdminMenu(Integer roleId);
    List<PageTree> getRoleRights(Integer roleId);
    List<Integer> getRightsIdList(Integer roleId);
    Integer addRights(Integer roleId, List<Integer> rights);
    Integer deleteRight(Integer pageId, Integer roleId);
}
