package com.example.deleblog.controller;

import com.example.deleblog.payload.UserRequestDto;
import com.example.deleblog.services.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static com.example.deleblog.enums.Role.ADMIN;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(controllers = AuthController.class)
class AuthControllerTest {
    @MockBean
    private UserService userService;

    @Autowired
    private MockMvc mockMvc;

    private ObjectMapper objectMapper;

    @BeforeEach
    void setUp() { objectMapper = new ObjectMapper(); }

    @Test
    void signup() throws Exception{
        UserRequestDto requestDto = new UserRequestDto("name","username","example@gmail.com","password",ADMIN);

        MvcResult result = mockMvc.perform(post("/auth/signup")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(requestDto)))
                        .andReturn();

        assertThat(result).isNotNull();
        assertThat(result.getResponse()).isNotNull();
        assertThat(result.getResponse().getStatus()).isEqualTo(200);
    }

    @Test
    void login() throws Exception{
        UserRequestDto requestDto = new UserRequestDto("name","username","example@gmail.com","password",ADMIN);

        MvcResult result = mockMvc.perform(post("/auth/login")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(requestDto)))
                        .andReturn();

        assertThat(result).isNotNull();
        assertThat(result.getResponse()).isNotNull();
        assertThat(result.getResponse().getStatus()).isEqualTo(200);
    }
}