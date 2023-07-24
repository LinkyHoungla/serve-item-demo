package com.example.server.service.impl;

import com.example.server.constant.ApiError;
import com.example.server.dao.CompanionDao;
import com.example.server.exception.ApiException;
import com.example.server.model.entity.Companion;
import com.example.server.model.entity.Store;
import com.example.server.service.CompanionService;
import com.example.server.util.Uuid;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

@Service
public class CompanionServiceImpl implements CompanionService {
    @Autowired
    private CompanionDao companionDao;

    @Override
    public PageInfo<Companion> getCompanionList(String query, Integer pageNum, Integer pageSize) {
        // 使用PageHelper进行分页设置
        PageHelper.startPage(pageNum, pageSize);
        // 调用分页查询的方法
        Page<Companion> companionPage = companionDao.getCompanionList(query);
        // 封装分页结果为PageInfo对象
        return new PageInfo<>(companionPage);
    }

    @Override
    public Store getCompanionInfo(String cid) {
        return companionDao.getCompanionInfo(cid);
    }

    @Override
    public Integer addCompanion(Companion companion) {
        int times = 0;
        while (true) {
            companion.setCid(Uuid.generateUniqueId());
            try {
                int len = companionDao.addCompanion(companion);
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
    public Integer updateCompanion(String cid, Companion companion) {
        companion.setCid(cid);
        return companionDao.updateCompanion(companion);
    }

    @Override
    public Integer deleteCompanion(String cid) {
        return companionDao.deleteCompanion(cid);
    }
}
