package com.example.server.constant;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ApiError {
    E400(400, "Bad Request"),
    E401(401, "Unauthorized"),
    E404(404, "Not Found"),
    E450(450, "Illegal Token"),
    E451(451, "Token Expired");

    private final Integer code;
    private final String message;
}
