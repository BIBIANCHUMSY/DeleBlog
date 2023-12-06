package com.example.deleblog.services.serviceimplementation;

import com.example.deleblog.repositories.LikeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class LikeServiceImplTest {

    @Mock
    private LikeRepository likeRepository;


    @InjectMocks
    private LikeServiceImpl likeService;

    @BeforeEach
    void setUp() {

    }

    @Test
    void likeComment() {
    }
}