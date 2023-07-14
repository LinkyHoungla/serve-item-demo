package com.example.server.controller;

import com.example.server.constant.ApiError;
import com.example.server.exception.ApiException;
import com.example.server.model.ApiResponse;
import com.example.server.model.entity.AdminInfo;
import com.example.server.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

@RestController
@RequestMapping("/upload")
public class updateController {
    private static final String FILEPATH = "E:/Project/learning/vue/web-item-demo/server/src/main/resources/static";

    @Autowired
    private AdminService adminService;

    @PostMapping("/avatar/admin/{adminId}")
    public ApiResponse uploadFile(@PathVariable("adminId") Integer adminId, MultipartFile avatar, HttpServletRequest request) {

        try {
            String path = FILEPATH + "/avatar" + "/admin/";
            String originalFilename = avatar.getOriginalFilename();
            String filename = adminId + "." + originalFilename.substring(originalFilename.lastIndexOf(".") + 1);

            adminService.updateAvatar(adminId, path + filename);
            saveFile(avatar, path, filename);
        } catch (IOException e) {
            System.out.println(e);
            throw new ApiException(ApiError.E404);
        }

        return ApiResponse.success(null);
    }

    public void saveFile(MultipartFile f, String path, String filename) throws IOException {
        File dir = new File(path);
        if(!dir.exists()) dir.mkdir();

        File file = new File(path + filename);
        f.transferTo(file);
    }
}
