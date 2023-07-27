package com.example.server.controller;

import com.example.server.model.ApiResponse;
import com.example.server.model.entity.Order;
import com.example.server.model.entity.Store;
import com.example.server.service.impl.OrderServiceImpl;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderServiceImpl orderService;

    @GetMapping("/list")
    public ApiResponse<PageInfo<Order>> getOrderList(String query, Integer pageNum, Integer pageSize) {
        return ApiResponse.success(orderService.getOrderList(query, pageNum, pageSize));
    }

    @GetMapping("/{oid}")
    public ApiResponse<Order> getOrder(@PathVariable("oid")String oid){
        return ApiResponse.success(orderService.getOrderInfo(oid));
    }

    @PostMapping
    public ApiResponse<Integer> addOrder(@RequestBody Order order){
        return ApiResponse.success(orderService.addOrder(order));
    }

    @PutMapping("/{oid}")
    public ApiResponse<Integer> updateOrder(@PathVariable("oid") String oid, @RequestBody Order order){
        return ApiResponse.success(orderService.updateOrder(oid, order));
    }

    @DeleteMapping("/{oid}")
    public ApiResponse<Integer> deleteOrder(@PathVariable("oid") String oid){
        return ApiResponse.success(orderService.deleteOrder(oid));
    }
}
