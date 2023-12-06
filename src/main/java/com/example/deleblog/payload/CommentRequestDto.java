package com.example.deleblog.payload;

import com.example.deleblog.entities.Post;
import com.example.deleblog.entities.User;


public record CommentRequestDto(String comments, User user, Post post, String username) {
}