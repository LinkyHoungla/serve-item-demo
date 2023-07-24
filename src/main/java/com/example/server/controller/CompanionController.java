package com.example.server.controller;

import com.example.server.model.ApiResponse;
import com.example.server.model.entity.Companion;
import com.example.server.model.entity.Store;
import com.example.server.service.impl.CompanionServiceImpl;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/companion")
public class CompanionController {
    @Autowired
    private CompanionServiceImpl companionService;

    @GetMapping("/list")
    public ApiResponse<PageInfo<Companion>> getCompanionList(String query, Integer pageNum, Integer pageSize) {
        return ApiResponse.success(companionService.getCompanionList(query, pageNum, pageSize));
    }

    @GetMapping("/{cid}")
    public ApiResponse<Store> getCompanion(@PathVariable("cid")String cid){
        return ApiResponse.success(companionService.getCompanionInfo(cid));
    }

    @PostMapping
    public ApiResponse<Integer> addCompanion(@RequestBody Companion companion){
        return ApiResponse.success(companionService.addCompanion(companion));
    }

    @PutMapping("/{cid}")
    public ApiResponse<Integer> updateCompanion(@PathVariable("cid") String cid, @RequestBody Companion companion){
        return ApiResponse.success(companionService.updateCompanion(cid, companion));
    }

    @DeleteMapping("/{cid}")
    public ApiResponse<Integer> deleteCompanion(@PathVariable("cid") String cid){
        return ApiResponse.success(companionService.deleteCompanion(cid));
    }
}
