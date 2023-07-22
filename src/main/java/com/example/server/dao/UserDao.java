package com.example.server.dao;

import com.example.server.model.entity.UserBasic;
import com.example.server.model.entity.UserInfo;
import com.example.server.model.entity.UserLogin;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.Date;

@Mapper
public interface UserDao {

    // SECTION 用户 基本信息
    // FUNCTION 获取 用户 基本信息 列表
    @Select({
            "<script>",
            "select * ",
            "from user_basic",
            "WHERE 1 = 1",
            "<if test='query != null'>",
            "AND uid LIKE CONCAT('%', #{query}, '%')",
            "</if>",
            "</script>"
    })
    Page<UserBasic> getUserBasicList(String query);

    // FUNCTION 获取 用户 基本信息
    @Select("SELECT * FROM user_basic WHERE uid = #{uid}")
    UserBasic getUserBasic(String uid);


    // FUNCTION 添加 用户
    @Insert("Insert user_basic(uid, wxid, phone, wallet_id) " +
            "VALUE(#{uid}, #{wxid}, #{phone}, #{walletId}) ")
    Integer addUser(UserBasic userBasic);

    // FUNCTION 修改 用户 手机号
    @Update("UPDATE user_basic SET phone = #{phone} WHERE uid = #{uid}")
    Integer updateUserPhone(String phone, String uid);

    // FUNCTION 修改 用户 状态
    @Update("UPDATE user_basic SET status = #{status} WHERE uid = #{uid}")
    Integer updateUserStatus(Integer status, String uid);

    // FUNCTION 删除 用户
    @Update("UPDATE user_basic SET status = -1 WHERE uid = #{uid}")
    Integer delete(String uid);

    // SECTION 用户 登录信息
    // FUNCTION 用户登录
    @Update("UPDATE user_login SET ip = #{ip}, login_time = #{time} WHERE username = #{username} AND password = #{password}")
    void userLogin(String ip, String username, String password, Date time);
    @Select("SELECT uid FROM user_login WHERE username = #{username} AND password = #{password}")
    String getUserLoginId(String username, String password);

    // FUNCTION 获取 用户 登录信息
    @Select("SELECT * FROM user_login WHERE uid = #{uid}")
    UserLogin getUserLogin(String uid);

    // FUNCTION 修改 用户 登录信息
    @Update("UPDATE user_login SET username = #{username}, password = #{password} WHERE uid = #{uid}")
    Integer updateUserLogin(String uid, String username, String password);

    // SECTION 用户 个人信息
    // FUNCTION 获取 用户 个人信息
    @Select("SELECT * FROM user_info WHERE uid = #{uid}")
    UserInfo getUserInfo(String uid);

    // FUNCTION 修改 用户个人信息
    @Update("UPDATE user_info " +
            "SET nickname = #{nickname}, gender = #{gender}, age = #{age}, location = #{location}, birthday = #{birthday} " +
            "WHERE uid = #{uid}")
    Integer updateUserInfo(UserInfo userInfo);

    // FUNCTION 修改用户头像
    @Update("UPDATE user_info SET avatar = #{avatar} WHERE uid = #{uid}")
    Integer updateUserAvatar(String uid, String avatar);

}
