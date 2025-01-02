package com.uberApp.advices;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ApiResponse<T> {

//    @JsonFormat(pattern = "hh:mm:ss dd-MM-yyyy")
    private LocalDateTime timeStamp;
    private T data;
    private ApiError error;

    public ApiResponse() {
        this.timeStamp = LocalDateTime.now();
    }

    public ApiResponse(T data) {
        this();
        this.data = data;
    }

    public ApiResponse(ApiError error) {
        this();
        this.error = error;
    }
}
//    "timeStamp": "2024-12-31T12:00:00",
//            "error": {
//            "status": "NOT_FOUND",
//            "message": "Resource not found",
//            "subErrors": null
//            }
//            }

//ApiError apiError = ApiError.builder()
//        .status(HttpStatus.NOT_FOUND)
//        .message("Resource not found")
//        .build();
//
//ApiResponse<?> response = new ApiResponse<>(apiError);
