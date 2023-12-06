package com.example.deleblog.entities;

import com.example.deleblog.enums.Categories;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Optional;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Post extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String postTitle;

    private String description;

    private String imageUrl;

    @Enumerated(EnumType.STRING)
    private Categories categories;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private List<Comment> comment;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    private User user;
}
