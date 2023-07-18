package com.example.server.dao;

import com.example.server.model.entity.Right;
import com.example.server.model.vo.Menu;
import com.example.server.model.vo.PageList;
import com.example.server.model.vo.PageTree;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface RightDao {
    @Select("select * from webpage")
    List<PageList> getPageList();
    @Select("select * from webpage where parent_id = -1")
    List<PageTree> getParentPages();
    @Select("select * from webpage where parent_id = #{parentId}")
    List<PageTree> getChildPages(Integer parentId);
    @Select("SELECT p.* FROM webpage p JOIN role_page rp ON p.page_id = rp.page_id JOIN role r ON r.role_id = rp.role_id WHERE r.role_id = #{roleId} AND p.parent_id = -1")
    List<Menu> getParentMenusByRoleId(Integer roleId);
    @Select("SELECT p.* FROM webpage p JOIN role_page rp ON p.page_id = rp.page_id JOIN role r ON r.role_id = rp.role_id WHERE r.role_id = #{roleId} AND p.parent_id = #{parentId}")
    List<Menu> getChildMenusByRoleId(Integer parentId, Integer roleId);
}
