package com.example.server.service.impl;

import com.example.server.dao.ServiceTypeDao;
import com.example.server.model.entity.ServiceType;
import com.example.server.service.ServiceTypeService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceTypeServiceImpl implements ServiceTypeService {
    @Autowired
    private ServiceTypeDao serviceTypeDao;

    @Override
    public PageInfo<ServiceType> getServiceTypeList(String query, Integer pageNum, Integer pageSize) {
        // 使用PageHelper进行分页设置
        PageHelper.startPage(pageNum, pageSize);
        // 调用分页查询的方法
        Page<ServiceType> serviceTypePage = serviceTypeDao.getServiceTypeList(query);
        // 封装分页结果为PageInfo对象
        return new PageInfo<>(serviceTypePage);
    }

    @Override
    public Integer addServiceType(ServiceType serviceType) {
        return serviceTypeDao.addServiceType(serviceType);
    }

    @Override
    public Integer updateServiceType(Integer id, ServiceType serviceType) {
        serviceType.setId(id);
        return serviceTypeDao.updateServiceType(serviceType);
    }

    @Override
    public Integer deleteServiceType(Integer id) {
        return serviceTypeDao.deleteServiceType(id);
    }
}
