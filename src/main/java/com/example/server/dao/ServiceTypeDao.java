package com.example.server.dao;

import com.example.server.model.entity.ServiceType;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.*;

@Mapper
public interface ServiceTypeDao {
    // SECTION 服务 基本 信息
    // FUNCTION 获取 服务 列表分页
    @Select({
            "<script>",
            "select * ",
            "FROM `service` ",
            "WHERE 1 = 1 ",
            "<if test='query != null'>",
            "AND type LIKE CONCAT('%', #{query}, '%') ",
            "</if>",
            "</script>"
    })
    Page<ServiceType> getServiceTypeList(String query);

    // FUNCTION 添加 服务
    @Insert("Insert `service`(type, name, gender) " +
            "VALUE(#{type}, #{name}, #{gender}) ")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    Integer addServiceType(ServiceType ServiceType);

    // FUNCTION 修改 服务 信息
    @Update("UPDATE `service` " +
            "SET name = #{name},  gender = #{gender} " +
            "WHERE id = #{id}")
    Integer updateServiceType(ServiceType ServiceType);

    // FUNCTION 删除 服务
    @Delete("DELETE FROM `service` WHERE id = #{id}")
    Integer deleteServiceType(Integer id);
}
