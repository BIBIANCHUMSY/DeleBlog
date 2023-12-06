package com.example.deleblog.services.serviceimplementation;

import com.example.deleblog.entities.User;
import com.example.deleblog.enums.Categories;
import com.example.deleblog.enums.Role;
import com.example.deleblog.payload.ApiResponse;
import com.example.deleblog.payload.PostRequestDto;
import com.example.deleblog.payload.PostResponseDto;
import com.example.deleblog.repositories.PostRepository;
import com.example.deleblog.repositories.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.StatusResultMatchersExtensionsKt.isEqualTo;

@ExtendWith(MockitoExtension.class)
class PostServiceImplTest {

    @Mock
    private PostRepository repository;
    @Mock
    private UserRepository userRepository;
    @InjectMocks
    private PostServiceImpl postService;

    private User user;

    @BeforeEach
    void setUp() {
        user = User.builder()
                .name("John Doe")
                .username("johndoe")
                .email("johndoe@example.com")
                .password("password")
                .role(Role.ADMIN)
                .build();

    }

    @Test
    void createPost() {
        PostRequestDto requestDto = new PostRequestDto("Test Post","This is a test post","https://example.com/image.jpg", Categories.MaleWears,Role.ADMIN,user);
        when(userRepository.findByRole(Role.ADMIN)).thenReturn(Optional.of(user));
        ApiResponse response = postService.createPost(requestDto);
        assertThat(response).isNotNull();
        assertThat(response.getMessage()).isEqualTo("Post created");
        assertThat(response.getData()).isInstanceOf(PostResponseDto.class);
        assertThat(response.getStatus()).isEqualTo(HttpStatus.CREATED);
    }
}