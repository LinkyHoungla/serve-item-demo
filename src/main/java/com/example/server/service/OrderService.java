package com.example.server.service;

import com.example.server.model.entity.Order;
import com.github.pagehelper.PageInfo;

public interface OrderService {
    // SECTION 陪玩 信息
    // function 获取 陪玩 列表
    PageInfo<Order> getOrderList(String query, Integer pageNum, Integer pageSize);
    // FUNCTION 获取 陪玩 信息
    Order getOrderInfo(String oid);
    // function 添加 陪玩
    Integer addOrder(Order order);
    // function 修改 陪玩
    Integer updateOrder(String oid, Order order);
    // function 删除 陪玩
    Integer deleteOrder(String oid);
}
