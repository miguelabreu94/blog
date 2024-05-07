package com.abreu.blog.payload;
import com.abreu.blog.model.Pessoa;
import com.abreu.blog.model.Role;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private int id;
    private String username;
    private String password;
    private Pessoa pessoa;
    //private List<Post> posts;
    private Role role;

}
