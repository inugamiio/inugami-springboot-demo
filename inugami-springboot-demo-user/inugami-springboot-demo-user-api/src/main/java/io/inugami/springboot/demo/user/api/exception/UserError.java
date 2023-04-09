package io.inugami.springboot.demo.user.api.exception;

import io.inugami.api.exceptions.DefaultErrorCode;
import io.inugami.api.exceptions.ErrorCode;

import static io.inugami.api.exceptions.DefaultErrorCode.newBuilder;

public enum UserError implements ErrorCode {
    // ========================================================================
    // GLOBAL
    // ========================================================================
    USER_UNDEFINED_ERROR(newBuilder()
                                 .errorCode("USER-0_0")
                                 .statusCode(400)
                                 .message("undefined error occurs")
                                 .errorTypeTechnical()
                                 .category(UserError.DOMAIN)),
    // ========================================================================
    // CREATE
    // ========================================================================
    USER_DATA_REQUIRED(newBuilder()
                               .errorCode("USER-1_0")
                               .statusCode(400)
                               .message("user data required to create new user")
                               .errorTypeFunctional()
                               .category(UserError.DOMAIN)),


    USER_USER_ID_FORBIDDEN(newBuilder()
                                        .errorCode("USER-1_1")
                                        .statusCode(400)
                                        .message("can't create user with id")
                                        .errorTypeFunctional()
                                        .category(UserError.DOMAIN)),

    USER_USER_LASTNAME_REQUIRED(newBuilder()
                                        .errorCode("USER-1_2")
                                        .statusCode(400)
                                        .message("user's lastname required")
                                        .errorTypeFunctional()
                                        .category(UserError.DOMAIN)),

    USER_USER_FIRSTNAME_REQUIRED(newBuilder()
                                         .errorCode("USER-1_3")
                                         .statusCode(400)
                                         .message("user's firstname required")
                                         .errorTypeFunctional()
                                         .category(UserError.DOMAIN)),

    USER_USER_EMAIL_REQUIRED(newBuilder()
                                     .errorCode("USER-1_4")
                                     .statusCode(400)
                                     .message("user's email required")
                                     .errorTypeFunctional()
                                     .category(UserError.DOMAIN)),

    USER_CAN_NOT_BE_CREATED(newBuilder()
                                     .errorCode("USER-1_4")
                                     .statusCode(500)
                                     .message("can't create user")
                                     .errorTypeTechnical()
                                     .category(UserError.DOMAIN)),
    // ========================================================================
    // READ
    // ========================================================================
    USER_INVALID_ID(newBuilder()
                            .errorCode("USER-2_0")
                            .statusCode(400)
                            .message("invalid user id")
                            .errorTypeFunctional()
                            .category(UserError.DOMAIN)),

    USER_NOT_FOUND(newBuilder()
                            .errorCode("USER-2_1")
                            .statusCode(400)
                            .message("user not found")
                            .errorTypeFunctional()
                            .category(UserError.DOMAIN))
    // ========================================================================
    // UPDATE
    // ========================================================================

    // ========================================================================
    // DELETE
    // ========================================================================
    ;

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
