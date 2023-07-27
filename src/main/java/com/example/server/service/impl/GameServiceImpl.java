package com.example.server.service.impl;

import com.example.server.dao.GameDao;
import com.example.server.model.entity.Game;
import com.example.server.service.GameService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameServiceImpl implements GameService {
    @Autowired
    private GameDao gameDao;

    @Override
    public PageInfo<Game> getGameList(String query, Integer pageNum, Integer pageSize) {
        // 使用PageHelper进行分页设置
        PageHelper.startPage(pageNum, pageSize);
        // 调用分页查询的方法
        Page<Game> gamePage = gameDao.getGameList(query);
        // 封装分页结果为PageInfo对象
        return new PageInfo<>(gamePage);
    }

    @Override
    public Integer addGame(Game game) {
        return gameDao.addGame(game);
    }

    @Override
    public Integer updateGame(Integer id, Game game) {
        game.setId(id);
        return gameDao.updateGame(game);
    }

    @Override
    public Integer deleteGame(Integer id) {
        return gameDao.deleteGame(id);
    }
}
