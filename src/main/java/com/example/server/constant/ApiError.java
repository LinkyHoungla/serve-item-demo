package com.example.server.constant;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ApiError {
    E401(401, "Unauthorized"),
    E403(403, "Forbidden"),
    E450(450, "Illegal Token"),
    E451(451, "Token Expired"),
    E404(404, "Other");

    private final Integer code;
    private final String message;
}
