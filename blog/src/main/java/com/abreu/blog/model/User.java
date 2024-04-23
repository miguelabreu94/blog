package com.abreu.blog.model;
import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@Data
@Table(name="users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username;
    private String password;
    @OneToOne(cascade = CascadeType.ALL)
    private Pessoa pessoa;
    @OneToMany
    private List<Posts> posts;
    @Enumerated(EnumType.STRING)
    private Role role;

}
