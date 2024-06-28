package com.abreu.blog.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

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
    @OneToMany(mappedBy = "post",cascade = CascadeType.ALL)
    private Set<Comment> comments = new HashSet<>();
    @ElementCollection
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "post_categories", joinColumns = @JoinColumn(name = "post_id"))
    @Column(name = "category", nullable = false)
    private Set<Category> categories = new HashSet<>();
    @ManyToOne
    private User user; // TODO: Cada post terá apenas um autor (esse autor é considerado User ou Pessoa?)
    private String imageName;
    private LocalDateTime dateOfCreation;
    private LocalDateTime dateOfLastModification;
    @Column(nullable = false)
    private String slug;
}
