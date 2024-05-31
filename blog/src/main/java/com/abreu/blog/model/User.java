package com.abreu.blog.model;
import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Table(name="users")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username;
    private String password;
    @OneToOne(cascade = CascadeType.ALL)
    private Pessoa pessoa;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Post> posts;
    @Enumerated(EnumType.STRING)
    private Role role;
}