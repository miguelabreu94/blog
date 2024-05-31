package com.abreu.blog.payload;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CommentDTO {

    private int id;
    private String content;
    private UserDto user;
    private LocalDateTime dateOfCreation;
}
