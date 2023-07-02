package com.example.server.model;

import com.example.server.constant.ApiError;
import lombok.Data;

@Data
public class ApiResponse<T> {
    private int status;
    private String message;
    private T data;

    // 构造函数
    public ApiResponse(int status, String message, T data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    // 错误构造函数
    public ApiResponse(ApiError apiError) {
        this.status = apiError.getCode();
        this.message = apiError.getMessage();
    }

    // 静态方法：成功响应
    public static <T> ApiResponse<T> success(T data) {
        return new ApiResponse<>(200, "Success", data);
    }

    // 静态方法：失败响应
    public static <T> ApiResponse<T> error(int status, String message) {
        return new ApiResponse<>(status, message, null);
    }
}
