package com.abreu.blog.payload;

import com.abreu.blog.model.Category;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostDto {

    private int id;
    private String title;
    private String content;
    private Set<CommentDTO> comments = new HashSet<>();
    private Set<Category> categories;
    private UserDto user;
    private String imageName;
    private LocalDateTime dateOfCreation;
    private LocalDateTime dateOfLastModification;
    private String slug;
    private LocalDateTime scheduledDate;
}
