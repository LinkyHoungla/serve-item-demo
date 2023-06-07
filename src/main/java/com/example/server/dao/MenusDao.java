package com.example.server.dao;

import com.example.server.entity.Menus;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface MenusDao {
    @Select("select * from menus_list where parent_id = -1")
    public List<Menus> getParentMenus();

    @Select("select * from menus_list where parent_id = #{id}")
    public List<Menus> getChildMenus(Integer id);
}
