package com.sangyoon.beckend_practice.common.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Getter;
import org.springframework.http.ResponseEntity;

@Builder
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse<T> {
    private final int status;
    private final boolean success;
    private final String message;
    private T data;

    /** SUCCESS */
    public static <T>ResponseEntity<ApiResponse<T>> success(SuccessStatus status, T data) {
        ApiResponse<T> response = ApiResponse.<T>builder()
                .status(status.getStatusCode())
                .success(true)
                .message(status.getMessage())
                .data(data)
                .build();
        return ResponseEntity.status(status.getStatusCode()).body(response);
    }

    /** SUCCESS ONLY */
    public static ResponseEntity<ApiResponse<Void>> success_only(SuccessStatus status) {
        ApiResponse<Void> response = ApiResponse.<Void>builder()
                .status(status.getStatusCode())
                .success(true)
                .message(status.getMessage())
                .build();
        return ResponseEntity.status(status.getStatusCode()).body(response);
    }

    /** FAIL */
    public static ApiResponse<Void> fail(int status, String message) {
        return ApiResponse.<Void>builder()
                .status(status)
                .success(false)
                .message(message)
                .build();
    }

    /** FAIL ONLY */
    public static ApiResponse<Void> fail_only(ErrorStatus status) {
        return ApiResponse.<Void>builder()
                .status(status.getStatusCode())
                .success(false)
                .message(status.getMessage())
                .build();
    }
}
