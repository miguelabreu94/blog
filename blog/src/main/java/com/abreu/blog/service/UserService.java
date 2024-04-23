package com.abreu.blog.service;

import com.abreu.blog.payload.UserDto;
import java.util.List;

public interface UserService {
    UserDto getUser(int id);
    List<UserDto> getAllUsers();
    UserDto save (UserDto userDto);
    UserDto update (int id, UserDto userDto);
    void delete (int id);
}
