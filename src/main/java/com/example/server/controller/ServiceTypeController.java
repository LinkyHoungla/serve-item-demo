package com.example.server.controller;

import com.example.server.model.ApiResponse;
import com.example.server.model.entity.ServiceType;
import com.example.server.service.impl.ServiceTypeServiceImpl;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/service")
public class ServiceTypeController {
    @Autowired
    private ServiceTypeServiceImpl orderService;

    @GetMapping("/list")
    public ApiResponse<PageInfo<ServiceType>> getServiceTypeList(String query, Integer pageNum, Integer pageSize) {
        return ApiResponse.success(orderService.getServiceTypeList(query, pageNum, pageSize));
    }

    @PostMapping
    public ApiResponse<Integer> addServiceType(@RequestBody ServiceType serviceType){
        return ApiResponse.success(orderService.addServiceType(serviceType));
    }

    @PutMapping("/{id}")
    public ApiResponse<Integer> updateServiceType(@PathVariable("id") Integer id, @RequestBody ServiceType serviceType){
        return ApiResponse.success(orderService.updateServiceType(id, serviceType));
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Integer> deleteServiceType(@PathVariable("id") Integer id){
        return ApiResponse.success(orderService.deleteServiceType(id));
    }
}
