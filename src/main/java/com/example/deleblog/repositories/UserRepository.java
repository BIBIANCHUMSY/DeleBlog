package com.example.deleblog.repositories;

import com.example.deleblog.entities.User;
import com.example.deleblog.enums.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    @Query("select u from User u where u.role = ?1")
    Optional<User> findByRole(@NonNull Role role);

    @Query("select (count(u) > 0) from User u where u.role = ?1")
    boolean existsByRole(@NonNull Role role);

    @Query("select u from User u where u.username = ?1")
    User findByUsername(String username);

    @Query("select u from User u where upper(u.email) = upper(?1) and u.password = ?2")
    Optional<User> findByEmailAndPassword(@NonNull String email, @NonNull String password);

    @Query("select (count(u) > 0) from User u where upper(u.email) = upper(?1)")
    boolean checkIfEmailExists(@NonNull String email);
}
