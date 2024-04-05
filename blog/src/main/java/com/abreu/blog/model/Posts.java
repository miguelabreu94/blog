package com.abreu.blog.model;

import jakarta.persistence.*;

import java.util.List;


@Entity
public class Posts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @OneToMany
    private List<Comments> comments;
    @OneToMany
    private List<Categories> categories;


}
