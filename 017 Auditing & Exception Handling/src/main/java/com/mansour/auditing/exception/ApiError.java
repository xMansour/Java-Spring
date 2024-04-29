package com.mansour.auditing.exception;

import java.time.LocalDateTime;

public class ApiError {
    private String status;
    private String error;
    private String path;
    private LocalDateTime timestamp;

    public ApiError(String status, String error, String path, LocalDateTime timestamp) {
        this.status = status;
        this.error = error;
        this.path = path;
        this.timestamp = timestamp;
    }

}
