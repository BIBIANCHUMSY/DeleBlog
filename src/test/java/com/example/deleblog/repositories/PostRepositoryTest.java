package com.example.deleblog.repositories;

import com.example.deleblog.entities.Post;
import com.example.deleblog.entities.User;
import com.example.deleblog.enums.Categories;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static com.example.deleblog.enums.Role.ADMIN;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
class PostRepositoryTest {
    private final PostRepository repository;
    private Post post;
    @Autowired
    public PostRepositoryTest(PostRepository repository) {
        this.repository = repository;
    }

    @BeforeEach
    void setUp() {
        post = Post.builder()
                .postTitle("Football")
                .description("This brand is for sports")
                .imageUrl("https://example.com/image.jpg")
                .categories(Categories.MaleWears)
                .build();

    }

    @Test
    void findPostTitle() {
//        Post savedPost = repository.save(user);
//        assertThat(savedUser).isNotNull();
    }

    @Test
    void findByPostTitle() {
    }

    @Test
    void findById() {
    }
}