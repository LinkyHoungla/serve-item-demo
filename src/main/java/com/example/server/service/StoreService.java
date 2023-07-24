package com.example.server.service;

import com.example.server.model.entity.Store;
import com.github.pagehelper.PageInfo;

public interface StoreService {
    // SECTION 店铺 信息
    // function 获取 店铺 列表
    PageInfo<Store> getStoreList(String query, Integer pageNum, Integer pageSize);
    // FUNCTION 获取 店铺 信息
    Store getStoreInfo(String uid);
    // function 添加 店铺
    Integer addStore(Store store);
    // function 修改 店铺
    Integer updateStore(String sid, Store store);
    // function 删除 店铺
    Integer deleteStore(String uid);
}
