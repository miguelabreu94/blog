package com.abreu.blog.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Categories {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    // TODO: Devo fazer um ENUM com categorias já pré-definidas?
}
