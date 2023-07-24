package com.example.server.controller;

import com.example.server.model.ApiResponse;
import com.example.server.model.entity.Store;
import com.example.server.service.impl.StoreServiceImpl;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/store")
public class StoreController {
    @Autowired
    private StoreServiceImpl storeService;

    @GetMapping("/list")
    public ApiResponse<PageInfo<Store>> getStoreList(String query, Integer pageNum, Integer pageSize) {
        return ApiResponse.success(storeService.getStoreList(query, pageNum, pageSize));
    }

    @GetMapping("/{uid}")
    public ApiResponse<Store> getStore(@PathVariable("uid")String uid){
        return ApiResponse.success(storeService.getStoreInfo(uid));
    }

    @PostMapping
    public ApiResponse<Integer> addStore(@RequestBody Store store){
        return ApiResponse.success(storeService.addStore(store));
    }

    @PutMapping("/{uid}")
    public ApiResponse<Integer> updateStore(@PathVariable("uid") String uid, @RequestBody Store store){
        return ApiResponse.success(storeService.updateStore(uid, store));
    }

    @DeleteMapping("/{uid}")
    public ApiResponse<Integer> deleteStore(@PathVariable("uid") String uid){
        return ApiResponse.success(storeService.deleteStore(uid));
    }
}
