package com.example.server.dao;

import com.example.server.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserDao {

    @Select("select * from user where uid = #{uid}")
    public User getByUid(Integer uid);

    @Select("select * from user where username = #{username} and password = #{password}")
    public User getByLogin(String username, String password);

    @Select("select * from user where username = #{username}")
    public User getByLogin2(String username);
}
