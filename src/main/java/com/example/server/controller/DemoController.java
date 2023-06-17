package com.example.server.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

@RestController
public class DemoController {

    @PostMapping("/upload")
    public String uploadFile(String nickname, MultipartFile avatar, HttpServletRequest request) throws IOException {

        System.out.println(nickname);
        // 获取文件的原始名称
        System.out.println(avatar.getOriginalFilename());
        // 获取文件类型
        System.out.println(avatar.getContentType());

        // 获取服务器路径地址
        String path = request.getServletContext().getRealPath("/upload");

        System.out.println(path);
        saveFile(avatar, path);

        return "---";
    }

    public void saveFile(MultipartFile avatar, String path) throws IOException {
        File dir = new File(path);
        if(!dir.exists()) dir.mkdir();

        File file = new File(path + avatar.getOriginalFilename());
        avatar.transferTo(file);
    }

}
