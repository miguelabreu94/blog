package com.abreu.blog.payload;
import com.abreu.blog.model.Pessoa;
import com.abreu.blog.model.Role;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JsonIgnore
    private String password;
    private Pessoa pessoa;
    private Role role;

}
