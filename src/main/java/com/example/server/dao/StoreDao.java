package com.example.server.dao;

import com.example.server.model.entity.Store;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface StoreDao {
    // SECTION 店铺 基本 信息
    // FUNCTION 获取 店铺 列表
    @Select({
            "<script>",
            "select * ",
            "from store",
            "WHERE 1 = 1",
            "<if test='query != null'>",
            "AND store_id LIKE CONCAT('%', #{query}, '%')",
            "</if>",
            "</script>"
    })
    Page<Store> getStoreList(String query);

    // FUNCTION 获取 店铺 基本信息
    @Select("SELECT * FROM store WHERE store_id = #{sid}")
    Store getStoreInfo(String sid);

    // FUNCTION 添加 店铺
    @Insert("Insert store(store_id, store_name, store_avatar, store_desc, owner_id, contact_name, contact_phone) " +
            "VALUE(#{storeId}, #{storeName}, #{storeAvatar}, #{storeDesc}, #{ownerId}, #{contactName}, #{contactPhone}) ")
    Integer addStore(Store store);

    // FUNCTION 修改 店铺 信息
    @Update("UPDATE store " +
            "SET store_name = #{storeName}, store_avatar = #{storeAvatar}, store_desc = #{storeDesc} " +
            "WHERE store_id = #{storeId}")
    Integer updateStore(Store store);

    // FUNCTION 删除 店铺 信息
    @Update("UPDATE store SET status = -1 WHERE store_id = #{storeId}")
    Integer deleteStore(String storeId);
}
