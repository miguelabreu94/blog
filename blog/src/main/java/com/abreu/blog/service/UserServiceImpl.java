package com.abreu.blog.service;

import com.abreu.blog.exceptions.ResourceNotFoundException;
import com.abreu.blog.model.Pessoa;
import lombok.AllArgsConstructor;
import com.abreu.blog.model.User;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;
import com.abreu.blog.repository.UserRepository;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;

    @Override
    public Optional<User> getUser(int id) {
        return repository.findById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return repository.findAll();
    }

    @Override
    public User save(User user) {
        return repository.save(user);
    }

    @Override
    public User update(int id, User user) {
        User newUser = repository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException("user","id",id));
        newUser.setUsername(user.getUsername());
        newUser.setPassword(user.getPassword());
        newUser.setRole(user.getRole());
        newUser.setPosts(user.getPosts());
        return repository.save(newUser);
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }
}
