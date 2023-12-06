package com.example.deleblog.payload;

import com.example.deleblog.enums.Role;

import java.time.LocalDateTime;

public record UserResponseDto(String username, String email, Role role){
}