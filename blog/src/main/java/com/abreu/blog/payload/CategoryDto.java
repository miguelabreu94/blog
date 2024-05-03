package com.abreu.blog.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDto {

    private int id;
    private String categoryTitle;
    private String categoryDescription;
    //private List<Post> posts = new ArrayList<>();
}
