package com.sangyoon.beckend_practice.api.sample.controller;

import com.sangyoon.beckend_practice.common.exception.BadRequestException;
import com.sangyoon.beckend_practice.common.response.ApiResponse;
import com.sangyoon.beckend_practice.common.response.ErrorStatus;
import com.sangyoon.beckend_practice.common.response.SuccessStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class sampleController {

    // 응답 시 데이터 반환 없이 응답코드, 응답 메시지만 보낼 때
    @GetMapping("/getSample")
    public ResponseEntity<ApiResponse<Void>> getSample() {
        return ApiResponse.success_only(SuccessStatus.SEND_SAMPLE_SUCCESS);
    }

    // 응답 시 데이터 반환과 함께 응답코드, 응답 메세지를 보낼 때
    @GetMapping("/getSampleData")
    public ResponseEntity<ApiResponse<String>> getSampleData(@RequestParam String data) {
        return ApiResponse.success(SuccessStatus.SEND_SAMPLE_SUCCESS, data);
    }

    // 예외처리 예제
    @GetMapping("/exception/{isError}")
    public ResponseEntity<ApiResponse<Void>> exception(@PathVariable("isError") String isError) {
        if (isError.equals("true")) {
            // 커스텀 예외처리 (BadRequestException) 사용방법 및 ErrorStatus 사용방법
            throw new BadRequestException(ErrorStatus.NOT_FOUND_MEMBER_EXCEPTION.getMessage());
        }

        return ApiResponse.success_only(SuccessStatus.SEND_SAMPLE_SUCCESS);
    }
}
