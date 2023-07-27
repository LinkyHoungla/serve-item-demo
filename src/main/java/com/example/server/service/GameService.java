package com.example.server.service;

import com.example.server.model.entity.Game;
import com.github.pagehelper.PageInfo;

public interface GameService {
    // SECTION 陪玩 信息
    // function 获取 陪玩 列表
    PageInfo<Game> getGameList(String query, Integer pageNum, Integer pageSize);
    // function 添加 陪玩
    Integer addGame(Game game);
    // function 修改 陪玩
    Integer updateGame(Integer id, Game game);
    // function 删除 陪玩
    Integer deleteGame(Integer id);
}
