package com.abreu.blog.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Comments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(length = 5000)
    private String comment;
    @ManyToOne
    private Post post;
    @OneToOne
    private User user; // TODO: Cada comment terá apenas um autor (esse autor é considerado User ou Pessoa?)
}
