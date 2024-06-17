package com.abreu.blog.controller;
import com.abreu.blog.payload.UserDto;
import com.abreu.blog.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
public class UserController {

    private final UserService service;

    @CrossOrigin(origins = "http://localhost:3000/")
    @GetMapping("/user/{id}")
    public Optional<UserDto> getUser(@PathVariable int id) {
        return Optional.ofNullable(service.getUser(id));
    }

    @CrossOrigin(origins = "http://localhost:3000/")
    @GetMapping("/user")
    public ResponseEntity<List<UserDto>> getAll() {
        return ResponseEntity.ok(this.service.getAllUsers());
    }

    @CrossOrigin(origins = "http://localhost:3000/")
    @PostMapping("/user")
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
        UserDto createUserDto = this.service.save(userDto);
        return new ResponseEntity<>(createUserDto, HttpStatus.CREATED);
    }

    @CrossOrigin(origins = "http://localhost:3000/")
    @PutMapping("/user/{id}")
    public ResponseEntity<UserDto> update(@PathVariable int id, @RequestBody UserDto userDto) {
        UserDto updatedUser = this.service.update(id,userDto);
        return ResponseEntity.ok(updatedUser);
    }

    @CrossOrigin(origins = "http://localhost:3000/")
    @DeleteMapping("/user/{id}")
    public void deleteUser(@PathVariable int id) {
        service.delete(id);
    }
}