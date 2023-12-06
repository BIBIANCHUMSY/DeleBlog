package com.example.deleblog.repositories;

import com.example.deleblog.entities.Like;
import com.example.deleblog.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface LikeRepository extends JpaRepository<Like, Long> {
    @Query("select l from Like l where l.post.id = ?1")
    boolean findByPostId(@NonNull Long id);
    @Transactional
    @Modifying
    @Query("delete from Like l where l.post = ?1")
    int deleteByPost(@NonNull Post post);

    @Query("select l from Like l where l.post.postTitle = ?1")
    boolean findByPostTitle(@NonNull String postTitle);
}
