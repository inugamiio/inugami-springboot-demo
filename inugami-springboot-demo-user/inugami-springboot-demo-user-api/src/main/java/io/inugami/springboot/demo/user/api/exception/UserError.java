package io.inugami.springboot.demo.user.api.exception;

import io.inugami.api.exceptions.DefaultErrorCode;
import io.inugami.api.exceptions.ErrorCode;

import static io.inugami.api.exceptions.DefaultErrorCode.newBuilder;

public enum UserError implements ErrorCode {
    USER_UNDEFINED_ERROR(newBuilder()
                                 .errorCode("USER-0_0")
                                 .statusCode(400)
                                 .message("undefined error occurs")
                                 .category(UserError.DOMAIN)
    );

    private static final String DOMAIN = "user";

    private UserError(final DefaultErrorCode.DefaultErrorCodeBuilder errorBuilder) {
        errorCode = errorBuilder.build();
    }

    private final ErrorCode errorCode;

    @Override
    public ErrorCode getCurrentErrorCode() {
        return errorCode;
    }
}
