package com.example.deleblog.services.serviceimplementation;

import com.example.deleblog.entities.Comment;
import com.example.deleblog.entities.Like;
import com.example.deleblog.entities.Post;
import com.example.deleblog.exceptions.InvalidPostException;
import com.example.deleblog.exceptions.inValidPasswordException;
import com.example.deleblog.payload.ApiResponse;
import com.example.deleblog.repositories.CommentRepository;
import com.example.deleblog.repositories.LikeRepository;
import com.example.deleblog.repositories.PostRepository;
import com.example.deleblog.services.LikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class LikeServiceImpl implements LikeService {

    private final PostRepository postRepository;
    private final LikeRepository likeRepository;
    private final CommentRepository commentRepository;

    @Override
    public ApiResponse likePost(String postTitle) {
        Optional<Post> post = postRepository.findByPostTitle(postTitle);
        Post post1 = post.get();
        Like like = Like.builder()
                .post(post1)
                .build();
        likeRepository.save(like);
            return new ApiResponse("Like success", HttpStatus.OK);
    }

    @Override
    public ApiResponse likeComment(Long commentId) {
        Optional<Comment> comment = commentRepository.findById(commentId);
        Comment comment1 = comment.get();
        Like like = Like.builder()
                .comment(comment1)
                .build();
        likeRepository.save(like);
        return new ApiResponse("Comment like successful",HttpStatus.OK);
    }
//    throw new InvalidPostException("Post not found");
}
