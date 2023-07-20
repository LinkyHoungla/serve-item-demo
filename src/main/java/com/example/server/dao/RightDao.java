package com.example.server.dao;

import com.example.server.model.vo.Menu;
import com.example.server.model.vo.PageList;
import com.example.server.model.vo.PageTree;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
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
    @Select("SELECT p.* FROM webpage p JOIN role_page rp ON p.page_id = rp.page_id JOIN role r ON r.role_id = rp.role_id WHERE r.role_id = #{roleId} AND p.parent_id = -1")
    List<PageTree> getParentRightsByRoleId(Integer roleId);
    @Select("SELECT p.* FROM webpage p JOIN role_page rp ON p.page_id = rp.page_id JOIN role r ON r.role_id = rp.role_id WHERE r.role_id = #{roleId} AND p.parent_id = #{parentId}")
    List<PageTree> getChildRightsByRoleId(Integer parentId, Integer roleId);
    @Select("SELECT rp.page_id FROM role_page rp JOIN webpage p ON p.`level` = 3 AND rp.page_id = p.page_id WHERE rp.role_id = #{roleId}")
    List<Integer> getRightsIdList(Integer roleId);
    Integer addRights(@Param("roleId") Integer roleId, @Param("rights") List<Integer> rights);
    @Delete("DELETE FROM role_page WHERE role_id = #{roleId}")
    Integer deleteAllRight(Integer roleId);
    @Delete("DELETE FROM role_page WHERE role_id = #{roleId} AND page_id = #{pageId}")
    Integer deleteRight(Integer pageId, Integer roleId);
}
