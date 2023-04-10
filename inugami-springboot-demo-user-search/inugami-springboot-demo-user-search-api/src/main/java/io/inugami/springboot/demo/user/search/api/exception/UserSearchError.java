package io.inugami.springboot.demo.user.search.api.exception;

import io.inugami.api.exceptions.DefaultErrorCode;
import io.inugami.api.exceptions.ErrorCode;

import static io.inugami.api.exceptions.DefaultErrorCode.newBuilder;

public enum UserSearchError implements ErrorCode {
    // ========================================================================
    // GLOBAL
    // ========================================================================
    USER_SEARCH_UNDEFINED_ERROR(newBuilder()
                                        .errorCode("USER_SEARCH-0_0")
                                        .statusCode(500)
                                        .message("undefined error occurs")
                                        .category(UserSearchError.DOMAIN)),
    // ========================================================================
    // CREATE
    // ========================================================================
    USER_SEARCH_INVALID_ID(newBuilder()
                                   .errorCode("USER_SEARCH-1_0")
                                   .statusCode(400)
                                   .message("invalid user's id")
                                   .errorTypeFunctional()
                                   .category(UserSearchError.DOMAIN))
    // ========================================================================
    // READ
    // ========================================================================

    // ========================================================================
    // UPDATE
    // ========================================================================

    // ========================================================================
    // DELETE
    // ========================================================================
    ;

    private static final String DOMAIN = "user_search";

    private UserSearchError(final DefaultErrorCode.DefaultErrorCodeBuilder errorBuilder) {
        errorCode = errorBuilder.build();
    }

    private final ErrorCode errorCode;

    @Override
    public ErrorCode getCurrentErrorCode() {
        return errorCode;
    }
}
