package com.example.server.dao;

import com.example.server.entity.Menus;
import com.example.server.entity.Rights;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface RightsDao {
    @Select("select * from rights where parent_id = -1")
    public List<Menus> getParentMenus();

    @Select("select * from rights where parent_id = #{parentId}")
    public List<Menus> getChildMenus(Integer parentId);

    @Select("select * from rights where parent_id = -1")
    public List<Rights> getParentRights();

    @Select("select * from rights where parent_id = #{parentId}")
    public List<Rights> getChildRights(Integer parentId);

    @Select("select * from rights")
    public List<Rights> getParentAllRights();
}
