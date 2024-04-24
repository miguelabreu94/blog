package com.abreu.blog.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.List;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 10000)
    private String content;
    @Column(length = 100,nullable = false)
    private String title;
    @OneToMany
    private List<Comments> comments;
    @ManyToOne
    @JoinColumn(name="category_id")
    private Category category;
    @ManyToOne
    private User user; // TODO: Cada post terá apenas um autor (esse autor é considerado User ou Pessoa?)
    private LocalDateTime dateOfCreation;


}
