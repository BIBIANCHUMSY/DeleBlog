package com.example.deleblog.controller;

import com.example.deleblog.payload.ApiResponse;
import com.example.deleblog.payload.UserRequestDto;
import com.example.deleblog.payload.UserResponseDto;
import com.example.deleblog.services.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RequiredArgsConstructor
@RestController
@RequestMapping("/auth")
public class AuthController {
    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<UserResponseDto> signup(@Valid @RequestBody UserRequestDto userRequestDto){
        return userService.signup(userRequestDto);
    }

    @PostMapping("/login")
    public ApiResponse login(@RequestBody UserRequestDto userRequestDto){
        return userService.login(userRequestDto);
    }
}
