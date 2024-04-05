package com.abreu.blog.model;

import jakarta.persistence.*;

@Entity
@Table(name="pessoas")
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    // TODO: BASE DE DADOS NÃO ESTÁ A ASSUMIR A STRING NO NOME

}
