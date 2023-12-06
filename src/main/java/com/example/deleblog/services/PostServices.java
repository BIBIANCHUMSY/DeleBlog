package com.example.deleblog.services;

import com.example.deleblog.enums.Role;
import com.example.deleblog.payload.ApiResponse;
import com.example.deleblog.payload.PostRequestDto;
import com.example.deleblog.payload.PostResponseDto;
import org.springframework.http.ResponseEntity;

public interface PostServices {
    public ApiResponse createPost(PostRequestDto postRequestDto);

    ApiResponse searchPost(String postTitle);

}
