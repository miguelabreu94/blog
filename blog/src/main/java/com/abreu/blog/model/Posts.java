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
public class Posts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @OneToMany
    private List<Comments> comments;
    @OneToMany
    private List<Categories> categories;
    @OneToOne
    private User user; // TODO: Cada post terá apenas um autor (esse autor é considerado User ou Pessoa?)
    private LocalDateTime dateOfCreation;


}
