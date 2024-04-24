package com.abreu.blog.payload;

import com.abreu.blog.model.Post;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDto {

    private int id;
    private String categoryTitle;
    private String categoryDescription;
    private List<Post> posts = new ArrayList<>();
}
