package com.example.server;

import com.example.server.dao.MenusDao;
import com.example.server.dao.UserDao;
import com.example.server.service.MenusService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ServerApplicationTests {

    @Autowired
    private UserDao userDao;

    @Autowired
    private MenusService menusService;

    @Test
    void contextLoads() {
        System.out.println(userDao.getByUid(1));
    }

    @Test
    void menusList() {
        menusService.getMenus();
    }

}
