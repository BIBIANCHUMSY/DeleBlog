package com.example.deleblog.controller;

import com.example.deleblog.entities.User;
import com.example.deleblog.payload.ApiResponse;
import com.example.deleblog.payload.CommentRequestDto;
import com.example.deleblog.services.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/")
public class CommentController {

    private final CommentService commentService;

    @PostMapping("/comment")
    public ApiResponse createComment(@RequestBody CommentRequestDto commentRequestDto,String username, @Param("postId"+"username") Long postId){
    return commentService.createComment(commentRequestDto,username ,postId);
    }
}
