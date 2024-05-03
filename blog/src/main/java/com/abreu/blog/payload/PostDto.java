package com.abreu.blog.payload;

import com.abreu.blog.model.Comments;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;
import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostDto {

    private String title;
    private String content;
    private List<Comments> comments;
    private CategoryDto category;
    private UserDto user;
    private LocalDateTime dateOfCreation;
}
