package com.abreu.blog.payload;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentDTO {

    private int id;
    private String content;
}
