package com.example.deleblog.payload;

import com.example.deleblog.entities.User;
import com.example.deleblog.enums.Categories;
import com.example.deleblog.enums.Role;

import java.io.Serializable;
public record PostRequestDto(String postTitle, String description, String imageUrl,
                             Categories categories, Role role, User user) {
}