package com.example.server.dao;

import com.example.server.model.entity.Game;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.*;

@Mapper
public interface GameDao {
    // SECTION 服务 基本 信息
    // FUNCTION 获取 服务 列表分页
    @Select({
            "<script>",
            "select * ",
            "FROM `game` ",
            "WHERE 1 = 1 ",
            "<if test='query != null'>",
            "AND type LIKE CONCAT('%', #{query}, '%') ",
            "</if>",
            "</script>"
    })
    Page<Game> getGameList(String query);

    // FUNCTION 添加 服务
    @Insert("Insert `game`(type, name, pid) " +
            "VALUE(#{type}, #{name}, #{pid}) ")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    Integer addGame(Game game);

    // FUNCTION 修改 服务 信息
    @Update("UPDATE `game` " +
            "SET name = #{name} " +
            "WHERE id = #{id}")
    Integer updateGame(Game game);

    // FUNCTION 删除 服务
    @Delete("DELETE FROM `game` WHERE id = #{id}")
    Integer deleteGame(Integer id);
}
