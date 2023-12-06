package com.example.deleblog.payload;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.http.HttpStatus;
@Data
public class ApiResponse {
    private String message;
    private Object data;
//    @JsonIgnore
    private HttpStatus status;

    public ApiResponse(String message, Object data, HttpStatus status) {
        this.message = message;
        this.data = data;
        this.status = status;
    }

    public ApiResponse(String message, Object data) {
        this.message = message;
        this.data = data;
    }

    public ApiResponse(String message, HttpStatus status) {
        this.message = message;
        this.status = status;
    }

}
