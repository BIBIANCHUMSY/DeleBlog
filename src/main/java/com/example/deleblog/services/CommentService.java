package com.example.deleblog.services;

import com.example.deleblog.entities.User;
import com.example.deleblog.payload.ApiResponse;
import com.example.deleblog.payload.CommentRequestDto;

public interface CommentService {
    ApiResponse createComment(CommentRequestDto commentRequestDto, String username ,Long postId);
}
