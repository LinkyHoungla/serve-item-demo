package com.example.server.dao;

import com.example.server.model.entity.Companion;
import com.example.server.model.entity.Store;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface CompanionDao {
    // SECTION 陪玩 基本 信息
    // FUNCTION 获取 陪玩 列表分页
    @Select({
            "<script>",
            "select * ",
            "from companion",
            "WHERE 1 = 1",
            "<if test='query != null'>",
            "AND cid LIKE CONCAT('%', #{query}, '%')",
            "</if>",
            "</script>"
    })
    Page<Companion> getCompanionList(String query);

    // FUNCTION 获取 陪玩 基本信息
    @Select("SELECT * FROM companion WHERE cid = #{cid}")
    Store getCompanionInfo(String cid);

    // FUNCTION 添加 陪玩
    @Insert("Insert companion(cid, uid, sid, signature) " +
            "VALUE(#{cid}, #{uid}, #{sid}, #{signature}) ")
    Integer addCompanion(Companion companion);

    // FUNCTION 修改 陪玩 信息
    @Update("UPDATE companion " +
            "SET signature = #{signature} " +
            "WHERE cid = #{cid}")
    Integer updateCompanion(Companion companion);

    // FUNCTION 删除 陪玩
    @Update("UPDATE companion SET status = -1 WHERE cid = #{cid}")
    Integer deleteCompanion(String cid);
}
