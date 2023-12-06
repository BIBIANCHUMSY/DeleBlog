package com.example.deleblog.controller;

import com.example.deleblog.enums.Role;
import com.example.deleblog.payload.ApiResponse;
import com.example.deleblog.payload.PostRequestDto;
import com.example.deleblog.payload.PostResponseDto;
import com.example.deleblog.services.PostServices;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/")
public class PostController {

    private final PostServices postServices;

@PostMapping("/post")
    public ApiResponse createPost(@RequestBody PostRequestDto postRequestDto){
    return postServices.createPost(postRequestDto);
    }

    @GetMapping("/searchPost")
    public ApiResponse searchPost(@Param("post_title") String postTitle){
    return postServices.searchPost(postTitle);
    }
}
