package com.example.deleblog.services;

import com.example.deleblog.payload.ApiResponse;
import com.example.deleblog.payload.UserRequestDto;
import com.example.deleblog.payload.UserResponseDto;
import org.springframework.http.ResponseEntity;


public interface UserService {
    ResponseEntity<UserResponseDto> signup(UserRequestDto userRequestDto);

    ApiResponse login(UserRequestDto userRequestDto);
}
