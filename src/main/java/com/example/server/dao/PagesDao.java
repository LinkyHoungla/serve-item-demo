package com.example.server.dao;

import com.example.server.model.Menus;
import com.example.server.model.entity.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PagesDao {
    @Select("select * from pages where parent_id = -1")
    public List<Menus> getParentMenus();

    @Select("SELECT p.* FROM pages p INNER JOIN role_page rp ON p.id = rp.page_id WHERE rp.role_id = #{roleId} AND p.parent_id = -1")
    public List<Menus> getParentMenusByRoleId(Integer roleId);

    @Select("select * from pages where parent_id = #{parentId}")
    public List<Menus> getChildMenus(Integer parentId);

    @Select("SELECT p.* FROM pages p INNER JOIN role_page rp ON p.id = rp.page_id WHERE rp.role_id = #{roleId} AND p.parent_id = #{parentId}")
    public List<Menus> getChildMenusByRoleId(Integer parentId,Integer roleId);

    @Select("select * from pages where parent_id = -1")
    public List<Page> getParentRights();

    @Select("select * from pages where parent_id = #{parentId}")
    public List<Page> getChildRights(Integer parentId);

    @Select("select * from pages")
    public List<Page> getAllRights();
}
