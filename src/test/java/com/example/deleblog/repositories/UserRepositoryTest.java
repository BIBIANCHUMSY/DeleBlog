package com.example.deleblog.repositories;

import com.example.deleblog.entities.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import java.util.Optional;

import static com.example.deleblog.enums.Role.ADMIN;
import static com.example.deleblog.enums.Role.CUSTOMERS;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
class UserRepositoryTest {


    private final UserRepository repository;
    private User user;

    @Autowired
    public UserRepositoryTest(UserRepository repository) {
        this.repository = repository;
    }

    @BeforeEach
    void setUp() {
       user = User.builder()
                .name("name")
                .role(ADMIN)
                .username("username")
                .email("example@gmail.com")
                .password("password")
                .build();
    }
    @Test
    void savedUser(){
    User savedUser = repository.save(user);
    assertThat(savedUser).isNotNull();
    }
    @Test
    void findByRole() {
        savedUser();
        Optional<User> user1= repository.findByRole(ADMIN);
        assertThat(user1).isNotEmpty();
    }

    @Test
    void existsByRole() {
        savedUser();
        boolean user = repository.existsByRole(ADMIN);
        assertThat(user).isTrue();
    }

    @Test
    void findByUsername() {
        savedUser();
        user = repository.findByUsername("username");
        assertThat(user).isNotNull();
    }

    @Test
    void findByEmailAndPassword() {
    }

    @Test
    void checkIfEmailExists() {
    }
}