package com.example.server.dao;

import com.example.server.entity.Menus;
import com.example.server.entity.Pages;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PagesDao {
    @Select("select * from pages where parent_id = -1")
    public List<Menus> getParentMenus();

    @Select("select * from pages where parent_id = #{parentId}")
    public List<Menus> getChildMenus(Integer parentId);

    @Select("select * from pages where parent_id = -1")
    public List<Pages> getParentRights();

    @Select("select * from pages where parent_id = #{parentId}")
    public List<Pages> getChildRights(Integer parentId);

    @Select("select * from pages")
    public List<Pages> getParentAllRights();
}
