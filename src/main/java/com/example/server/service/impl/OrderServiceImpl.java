package com.example.server.service.impl;

import com.example.server.constant.ApiError;
import com.example.server.dao.OrderDao;
import com.example.server.exception.ApiException;
import com.example.server.model.entity.Order;
import com.example.server.model.entity.Store;
import com.example.server.service.OrderService;
import com.example.server.util.Uuid;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderDao orderDao;

    @Override
    public PageInfo<Order> getOrderList(String query, Integer pageNum, Integer pageSize) {
        // 使用PageHelper进行分页设置
        PageHelper.startPage(pageNum, pageSize);
        // 调用分页查询的方法
        Page<Order> orderPage = orderDao.getOrderList(query);
        // 封装分页结果为PageInfo对象
        return new PageInfo<>(orderPage);
    }

    @Override
    public Store getOrderInfo(String oid) {
        return orderDao.getOrderInfo(oid);
    }

    @Override
    public Integer addOrder(Order order) {
        int times = 0;
        while (true) {
            order.setOid(Uuid.generateUniqueId());
            try {
                int len = orderDao.addOrder(order);
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
    public Integer updateOrder(String oid, Order order) {
        order.setOid(oid);
        return orderDao.updateOrder(order);
    }

    @Override
    public Integer deleteOrder(String oid) {
        return orderDao.deleteOrder(oid);
    }
}
