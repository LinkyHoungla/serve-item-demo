package com.example.server.dao;

import com.example.server.model.param.PageParam;
import com.example.server.model.vo.Menu;
import com.example.server.model.vo.PageList;
import com.example.server.model.vo.PageTree;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface RightDao {
    @Select({
            "<script>",
            "select * ",
            "from webpage",
            "WHERE 1 = 1",
            "<if test='query != null'>",
            "AND path LIKE CONCAT('%', #{query}, '%')",
            "</if>",
            "</script>"
    })
    Page<PageList> getPageList(String query);
    @Select({
            "<script>",
            "select * ",
            "from webpage",
            "WHERE parent_id = -1",
            "<if test='query != null'>",
            "AND path LIKE CONCAT('%', #{query}, '%')",
            "</if>",
            "</script>"
    })
    Page<PageTree> getPageTreeByPage(String query);
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
    @Select("SELECT w.page_id, w.parent_id " +
            "FROM webpage w " +
            "INNER JOIN role_page rr ON w.page_id = rr.page_id " +
            "WHERE rr.role_id = #{roleId} " +
            "  AND NOT EXISTS ( " +
            "    SELECT 1 " +
            "    FROM webpage AS child " +
            "    WHERE child.parent_id = w.page_id " +
            "  )")
    List<Integer> getRightsIdList(Integer roleId);
    @Insert("INSERT webpage(parent_id, `name`, path, level) VALUES(#{parentId}, #{name}, #{path}, #{level})")
    Integer addPage(PageParam param);
    Integer addRights(@Param("roleId") Integer roleId, @Param("rights") List<Integer> rights);
    @Delete("DELETE FROM role_page WHERE role_id = #{roleId}")
    Integer deleteAllRight(Integer roleId);
    @Delete("DELETE FROM role_page WHERE role_id = #{roleId} AND page_id = #{pageId}")
    Integer deleteRight(Integer pageId, Integer roleId);
    @Delete("DELETE FROM webpage WHERE page_id = #{pageId}")
    Integer deletePage(Integer pageId);
    @Update("UPDATE webpage SET `name` = #{param.name}, path = #{param.path} WHERE page_id = #{pageId}")
    Integer updatePage(PageParam param, Integer pageId);
}
