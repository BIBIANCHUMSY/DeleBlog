package com.example.deleblog.controller;

import com.example.deleblog.payload.ApiResponse;
import com.example.deleblog.services.LikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class LikeController {

    private final LikeService likeService;

    @PostMapping("like_post")
    public ApiResponse likePost(@Param("post_title")String postTitle){
        return likeService.likePost(postTitle);
    }

    @PostMapping("/post_comment")
    public ApiResponse likeComment(@Param("comment_id") Long commentId){
        return likeService.likeComment(commentId);
    }
}
