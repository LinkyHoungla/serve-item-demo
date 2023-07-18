package com.example.server.dao;

import com.example.server.model.entity.AdminInfo;
import com.example.server.model.vo.AdminInfoWithRole;
import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.*;

@Mapper
public interface AdminInfoDao {

    // 查找 AdminInfo 根据 uid
    @Select("SELECT * FROM admin_info WHERE admin_id = #{id}")
    AdminInfo getAdminInfoById(Integer id);

    // 查找带Role的Admin
    @Select({
            "<script>",
            "SELECT ai.*, r.* ",
            "FROM admin_info ai ",
            "INNER JOIN role r ON ai.role_id = r.role_id ",
            "WHERE 1 = 1",
            "<if test='query != null'>",
            "AND full_name LIKE CONCAT('%', #{query}, '%')",
            "</if>",
            "</script>"
            })
    @Results({
            @Result(property = "role", column = "role_id",
                    one = @One(select = "com.example.server.dao.RoleDao.getRoleById"))
    })
    Page<AdminInfoWithRole> findAdminInfoWithRoleByPage(String query);

    // 查找 roleId 根据 id
    @Select("SELECT ai.role_id FROM admin_info ai WHERE admin_id = #{id}")
    Integer getRoleIdByAdminId(Integer id);

    // 添加
    @Insert("INSERT INTO admin_info (full_name, role_id, status, create_at, update_at) " +
            "VALUES (#{fullName}, #{roleId}, 0, #{createAt}, #{updateAt})")
    @Options(useGeneratedKeys = true, keyProperty = "adminId")
    Integer addAdminInfo(AdminInfo adminInfo);

    // 更新 信息
    @Update("UPDATE admin_info " +
            "SET full_name = #{fullName}, role_Id = #{roleId}, update_at = #{updateAt} " +
            "WHERE admin_id = #{adminId}")
    Integer updateAdminInfo(AdminInfo adminInfo);

    // 更新 头像
    @Update("UPDATE admin_info SET avatar = #{avatar} WHERE admin_id = #{adminId}")
    void updateAvatar(Integer adminId, String avatar);

    // 删除
    @Delete("DELETE FROM admin_info WHERE admin_id = #{account}")
    Integer deleteAdminInfoById(Integer account);
}
