package com.example.deleblog.services.serviceimplementation;

import com.example.deleblog.entities.User;
import com.example.deleblog.payload.ApiResponse;
import com.example.deleblog.payload.UserRequestDto;
import com.example.deleblog.payload.UserResponseDto;
import com.example.deleblog.repositories.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static com.example.deleblog.enums.Role.ADMIN;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServicesTest {
    @Mock
    private UserRepository repository;

    @InjectMocks
    private UserServices userServices;
    private User user;

    @BeforeEach
    void setUp() {
        user = User.builder()
//                .name("name")
                .role(ADMIN)
                .username("username")
                .email("example@gmail.com")
                .password("password")
                .build();
    }

    @Test
    void signup() {
        UserRequestDto requestDto = new UserRequestDto("name","username","example@gmail.com","password",ADMIN);
        UserResponseDto responseDto = new UserResponseDto(requestDto.getUsername(),requestDto.getEmail(),requestDto.getRole());
        when(repository.checkIfEmailExists(requestDto.getEmail())).thenReturn(false);

        ResponseEntity<UserResponseDto> response = userServices.signup(requestDto);
        assertThat(response).isNotNull();
        assertThat(response.getBody()).isEqualTo(responseDto);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.CREATED);
    }

    @Test
    void login() {

    }
}