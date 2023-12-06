package com.example.deleblog.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Comment extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private String comments;

//    private Integer likeCount = 0;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private User user;

    @ManyToOne
    private Post post;
}
