package com.example.server;

import com.example.server.service.impl.RightServiceImpl;
import com.example.server.service.impl.UserServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ServerApplicationTests {

    @Autowired
    private UserServiceImpl userService;

    @Test
    void contextLoads() {
        System.out.println(userService.userLogin("user_77192e9d28", "6f42dc0c42767d42","192.168.1.1"));
    }

}
