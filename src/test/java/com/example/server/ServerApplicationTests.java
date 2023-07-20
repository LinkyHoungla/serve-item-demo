package com.example.server;

import com.example.server.service.impl.RightServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ServerApplicationTests {

    @Autowired
    private RightServiceImpl rightService;

    @Test
    void contextLoads() {
        System.out.println(rightService.getPageTreeByPage(null, 1,10));
    }

}
