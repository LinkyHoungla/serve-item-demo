package com.example.server.exception;

import com.example.server.model.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

// 全局异常处理器

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ApiException.class)
    public ResponseEntity<ApiResponse<Void>> handleApiException(ApiException ax) {
        ApiResponse<Void> response = new ApiResponse<>(ax.getApiError());
        return ResponseEntity.status(response.getStatus()).body(response);
    }

}
