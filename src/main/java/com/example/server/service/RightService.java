package com.example.server.service;


import com.example.server.model.vo.Menu;
import com.example.server.model.vo.PageList;
import com.example.server.model.vo.PageTree;

import java.util.List;

public interface RightService {
    List<PageList> getPageList();
    List<PageTree> getPageTree();
    List<Menu> getAdminMenu(Integer roleId);
    List<PageTree> getRoleRights(Integer roleId);
}
