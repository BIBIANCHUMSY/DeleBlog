package com.example.deleblog.services.serviceimplementation;

import com.example.deleblog.entities.Comment;
import com.example.deleblog.entities.Post;
import com.example.deleblog.entities.User;
import com.example.deleblog.enums.Role;
import com.example.deleblog.exceptions.InvalidPostException;
import com.example.deleblog.exceptions.PostNotAllowedException;
import com.example.deleblog.exceptions.illegalPostException;
import com.example.deleblog.payload.*;
import com.example.deleblog.repositories.CommentRepository;
import com.example.deleblog.repositories.PostRepository;
import com.example.deleblog.repositories.UserRepository;
import com.example.deleblog.services.PostServices;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class PostServiceImpl implements PostServices {
    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final CommentRepository commentRepository;

    @Override
    public ApiResponse createPost(PostRequestDto postRequestDto) {
        if (postRequestDto.role() == Role.ADMIN) {
            User user = userRepository.findByRole(postRequestDto.role()).orElseThrow(
                    () -> new illegalPostException("No Admin assigned yet")
            );
            Post post = Post.builder()
                    .postTitle(postRequestDto.postTitle())
                    .description(postRequestDto.description())
                    .categories(postRequestDto.categories())
                    .user(user)
                    .imageUrl(postRequestDto.imageUrl())
                    .build();
            postRepository.save(post);
            PostResponseDto postResponseDto = PostResponseDto.builder()
                    .postTitle(post.getPostTitle())
                    .description(post.getDescription())
                    .build();
            return new ApiResponse("Post created", postResponseDto, HttpStatus.CREATED);
        } else {
            throw new PostNotAllowedException("Customer can't create posts");
        }
    }

    @Override
    public ApiResponse searchPost(String postTitle) {
        Post post = postRepository.findByPostTitle(postTitle).orElseThrow(()-> new InvalidPostException("Post not found"));
        if (post.getPostTitle().equals(postTitle)){
        PostResponseDto postResponseDto = PostResponseDto.builder()
                .postTitle(post.getPostTitle())
                .description(post.getDescription())
                .comment(post.getComment())
                .build();
            return new ApiResponse("Post found", postResponseDto, HttpStatus.ACCEPTED);
        }
        return new ApiResponse("Check postTitle", HttpStatus.BAD_REQUEST);
    }
}