package com.example.server;

import com.example.server.dao.AdminInfoDao;
import com.example.server.dao.UserDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ServerApplicationTests {

    @Autowired
    private AdminInfoDao adminInfoDao;

    @Test
    void contextLoads() {

        System.out.println(adminInfoDao.findAdminInfoWithRoleByPage(null));
    }

}
