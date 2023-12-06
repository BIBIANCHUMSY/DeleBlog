package com.example.deleblog.services.serviceimplementation;

import com.example.deleblog.entities.Comment;
import com.example.deleblog.payload.CommentResponseDto;
import com.example.deleblog.entities.Post;
import com.example.deleblog.entities.User;
import com.example.deleblog.exceptions.InvalidPostException;
import com.example.deleblog.payload.ApiResponse;
import com.example.deleblog.payload.CommentRequestDto;
import com.example.deleblog.repositories.CommentRepository;
import com.example.deleblog.repositories.PostRepository;
import com.example.deleblog.repositories.UserRepository;
import com.example.deleblog.services.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;
    private final PostRepository postRepository;
    private final UserRepository userRepository;

    @Override
    public ApiResponse createComment(CommentRequestDto commentRequestDto,String username,Long postId) {
        Post post = postRepository.findById(postId).orElseThrow(() -> new InvalidPostException("Post doesn't exist"));
        User user1 = userRepository.findByUsername(username);
        Comment comment = Comment.builder()
                .comments(commentRequestDto.comments())
                .post(post)
                .user(user1)
                .build();
        commentRepository.save(comment);
        CommentResponseDto commentResponseDto = CommentResponseDto.builder()
                .id(comment.getId())
                .comments(commentRequestDto.comments())
                .build();
        return new ApiResponse("Comment successful",commentResponseDto);
    }
}
