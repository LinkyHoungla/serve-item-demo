package com.example.server.dao;

import com.example.server.model.entity.Order;
import com.example.server.model.entity.Store;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface OrderDao {
    // SECTION 订单 基本 信息
    // FUNCTION 获取 订单 列表分页
    @Select({
            "<script>",
            "select * ",
            "FROM `order` ",
            "WHERE 1 = 1 ",
            "<if test='query != null'>",
            "AND oid LIKE CONCAT('%', #{query}, '%') ",
            "</if>",
            "</script>"
    })
    Page<Order> getOrderList(String query);

    // FUNCTION 获取 订单 基本信息
    @Select("SELECT * FROM `order` WHERE oid = #{oid}")
    Store getOrderInfo(String oid);

    // FUNCTION 添加 订单
    @Insert("Insert `order`(oid, uid, sid) " +
            "VALUE(#{oid}, #{uid}, #{sid}) ")
    Integer addOrder(Order order);

    // FUNCTION 修改 订单 信息
    @Update("UPDATE `order` " +
            "SET start_time = #{startTime},  end_time = #{endTime}, serve_duration = #{serveDuration} " +
            "WHERE oid = #{oid}")
    Integer updateOrder(Order order);

    // FUNCTION 删除 订单
    @Update("UPDATE `order` SET status = -1 WHERE oid = #{oid}")
    Integer deleteOrder(String oid);
}
