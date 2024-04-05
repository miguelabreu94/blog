package com.abreu.blog.service;

import com.abreu.blog.model.User;
import java.util.List;
import java.util.Optional;

public interface UserService {
    Optional<User> getUser(int id);
    List<User> getAllUsers();
    User save (User user);
    User update (User user);
    void delete (int id);
}
