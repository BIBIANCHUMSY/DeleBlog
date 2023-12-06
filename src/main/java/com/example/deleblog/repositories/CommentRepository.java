package com.example.deleblog.repositories;

import com.example.deleblog.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;
import java.util.Optional;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    @Query("select c from Comment c where c.post.id = ?1")
    List<Comment> findByPostId(@NonNull Long id);
    @Query("select c from Comment c where c.comments = ?1")
    Optional<Comment> findByComments(@NonNull String comments);
}