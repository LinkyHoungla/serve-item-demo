package com.example.server.service.impl;

import com.example.server.constant.ApiError;
import com.example.server.dao.StoreDao;
import com.example.server.exception.ApiException;
import com.example.server.model.entity.Store;
import com.example.server.service.StoreService;
import com.example.server.util.Uuid;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

@Service
public class StoreServiceImpl implements StoreService {
    @Autowired
    private StoreDao storeDao;

    @Override
    public PageInfo<Store> getStoreList(String query, Integer pageNum, Integer pageSize) {
        // 使用PageHelper进行分页设置
        PageHelper.startPage(pageNum, pageSize);
        // 调用分页查询的方法
        Page<Store> storePage = storeDao.getStoreList(query);
        // 封装分页结果为PageInfo对象
        return new PageInfo<>(storePage);
    }

    @Override
    public Store getStoreInfo(String uid) {
        return storeDao.getStoreInfo(uid);
    }

    @Override
    public Integer addStore(Store store) {
        int times = 0;
        while (true) {
            store.setStoreId(Uuid.generateUniqueId());
            try {
                int len = storeDao.addStore(store);
                if (len > 0) {
                    return len; // 插入成功，返回插入的行数
                }
            } catch (DuplicateKeyException e) {
                // 插入失败，继续循环生成新的 UID
                times ++;
                if (times >= 20)
                    throw new ApiException(ApiError.E404);
            }
        }
    }

    @Override
    public Integer updateStore(String sid, Store store) {
        store.setStoreId(sid);
        return storeDao.updateStore(store);
    }

    @Override
    public Integer deleteStore(String uid) {
        return storeDao.deleteStore(uid);
    }
}
