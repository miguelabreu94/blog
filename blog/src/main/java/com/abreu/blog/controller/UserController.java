package com.abreu.blog.controller;

import com.abreu.blog.model.User;
import com.abreu.blog.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
public class UserController {

    private final UserService service;

    @GetMapping("/user/{id}")
    public Optional<User> getUser(@PathVariable int id) {
        return service.getUser(id);
    }

    @GetMapping("/user")
    public List<User> getAll() {
        return service.getAllUsers();
    }

    @PostMapping("/user")
    public User save(@RequestBody User user) {
        return service.save(user);
    }

    @PutMapping("/user/{id}")
    public User update(@PathVariable int id, @RequestBody User user) {
        return service.update(user);
    }

    @DeleteMapping("/book/{id}")
    public void delete(@PathVariable int id) {
        service.delete(id);
    }
}
