package com.abreu.blog.payload;

import com.abreu.blog.model.Pessoa;
import com.abreu.blog.model.Posts;
import com.abreu.blog.model.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private int id;
    private String username;
    private String password;
    private Pessoa pessoa;
    private List<Posts> posts;
    private Role role;

}
