package com.sangyoon.beckend_practice.common.exception;

import org.springframework.http.HttpStatus;

public class UnAuthorizedException extends BaseException {
    public UnAuthorizedException() {
        super(HttpStatus.UNAUTHORIZED);
    }

    public UnAuthorizedException(String message) {
        super(HttpStatus.UNAUTHORIZED, message);
    }
}
