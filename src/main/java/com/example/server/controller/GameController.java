package com.example.server.controller;

import com.example.server.model.ApiResponse;
import com.example.server.model.entity.Game;
import com.example.server.service.impl.GameServiceImpl;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/game")
public class GameController {
    @Autowired
    private GameServiceImpl gameService;

    @GetMapping("/list")
    public ApiResponse<PageInfo<Game>> getGameList(String query, Integer pageNum, Integer pageSize) {
        return ApiResponse.success(gameService.getGameList(query, pageNum, pageSize));
    }

    @PostMapping
    public ApiResponse<Integer> addGame(@RequestBody Game game){
        return ApiResponse.success(gameService.addGame(game));
    }

    @PutMapping("/{id}")
    public ApiResponse<Integer> updateGame(@PathVariable("id") Integer id, @RequestBody Game game){
        return ApiResponse.success(gameService.updateGame(id, game));
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Integer> deleteGame(@PathVariable("id") Integer id){
        return ApiResponse.success(gameService.deleteGame(id));
    }
}
