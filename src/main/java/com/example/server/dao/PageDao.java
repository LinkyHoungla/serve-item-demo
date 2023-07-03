package com.example.server.dao;

import com.example.server.model.entity.Page;
import com.example.server.model.vo.Menu;
import com.example.server.model.vo.PageTree;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PageDao {
    @Select("select * from page")
    public List<Page> getAllPages();
    @Select("select * from page where parent_id = -1")
    public List<PageTree> getParentPages();
    @Select("select * from page where parent_id = #{parentId}")
    public List<PageTree> getChildPages(Integer parentId);
    @Select("SELECT p.* FROM page p JOIN role_page rp ON p.page_id = rp.page_id JOIN role r ON r.role_id = rp.role_id WHERE r.role_code = #{name} AND p.parent_id = -1")
    public List<Menu> getParentMenusByRoleName(String name);
    @Select("SELECT p.* FROM page p JOIN role_page rp ON p.page_id = rp.page_id JOIN role r ON r.role_id = rp.role_id WHERE r.role_code = #{name} AND p.parent_id = #{parentId}")
    public List<Menu> getChildMenusByRoleName(Integer parentId, String name);
}
