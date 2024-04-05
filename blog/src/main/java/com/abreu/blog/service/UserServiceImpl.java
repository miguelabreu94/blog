package com.abreu.blog.service;

import lombok.AllArgsConstructor;
import com.abreu.blog.model.User;
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
    public User update(User user) {
        return repository.save(user);
    }

    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }
}
