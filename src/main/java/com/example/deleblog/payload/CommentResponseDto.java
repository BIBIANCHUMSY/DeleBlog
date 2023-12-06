package com.example.deleblog.payload;

import lombok.Builder;

import java.io.Serializable;

@Builder
public record CommentResponseDto(Long id, String comments){
}