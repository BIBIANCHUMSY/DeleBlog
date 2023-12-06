package com.example.deleblog.payload;

import com.example.deleblog.entities.Comment;
import com.example.deleblog.entities.Post;
import lombok.Builder;

import java.io.Serializable;
import java.util.List;

/**
 * DTO for {@link Post}
 */
@Builder
public record PostResponseDto(String postTitle, String description, List<Comment> comment)  {
}