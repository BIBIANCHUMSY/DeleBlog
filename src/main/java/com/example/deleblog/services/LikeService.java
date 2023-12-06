package com.example.deleblog.services;

import com.example.deleblog.entities.Post;
import com.example.deleblog.payload.ApiResponse;

import java.util.Optional;

public interface LikeService {
    ApiResponse likePost(String postTitle);

    ApiResponse likeComment(Long commentId);




}
