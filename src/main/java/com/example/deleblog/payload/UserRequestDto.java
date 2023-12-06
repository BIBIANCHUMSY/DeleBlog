package com.example.deleblog.payload;

import com.example.deleblog.enums.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import org.hibernate.validator.constraints.Length;

import java.io.Serializable;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserRequestDto{
    String name;
    @NotBlank(message = "fill in username")
    String username;
    @Email(message = "Format Email properly")
    String email;
    @Length(message = "password length must be greater than 8, less than 20", min = 8, max = 20)
    String password;
    @NotNull(message = "provide Role")
    Role role;
}