package com.example.server.service;

import com.example.server.model.entity.ServiceType;
import com.github.pagehelper.PageInfo;

public interface ServiceTypeService {
    // SECTION 陪玩 信息
    // function 获取 陪玩 列表
    PageInfo<ServiceType> getServiceTypeList(String query, Integer pageNum, Integer pageSize);
    // function 添加 陪玩
    Integer addServiceType(ServiceType serviceType);
    // function 修改 陪玩
    Integer updateServiceType(Integer id, ServiceType serviceType);
    // function 删除 陪玩
    Integer deleteServiceType(Integer id);
}
