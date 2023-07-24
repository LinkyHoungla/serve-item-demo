package com.example.server.service;

import com.example.server.model.entity.Companion;
import com.example.server.model.entity.Store;
import com.github.pagehelper.PageInfo;

public interface CompanionService {
    // SECTION 陪玩 信息
    // function 获取 陪玩 列表
    PageInfo<Companion> getCompanionList(String query, Integer pageNum, Integer pageSize);
    // FUNCTION 获取 陪玩 信息
    Store getCompanionInfo(String cid);
    // function 添加 陪玩
    Integer addCompanion(Companion companion);
    // function 修改 陪玩
    Integer updateCompanion(String cid, Companion companion);
    // function 删除 陪玩
    Integer deleteCompanion(String cid);
}
