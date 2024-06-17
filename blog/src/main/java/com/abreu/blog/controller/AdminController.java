package com.abreu.blog.controller;
import com.abreu.blog.model.User;
import com.abreu.blog.service.AdminServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminServiceImpl adminService;

    @CrossOrigin(origins = "http://localhost:3000/")
    @GetMapping("/users")
    public ResponseEntity<?> getUsersWithUserRole() {
        try {
            Optional<User> users = adminService.getUsersWithUserRole();
            return ResponseEntity.ok(users);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to retrieve users.");
        }
    }

    @CrossOrigin(origins = "http://localhost:3000/")
    @PostMapping("/promote/{username}")
    public ResponseEntity<?> promoteToAdmin(@PathVariable String username) {
        try {
            User updatedUser = adminService.promoteAdmin(username);
            return ResponseEntity.ok(updatedUser);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @CrossOrigin(origins = "http://localhost:3000/")
    @PostMapping("/demote/{username}")
    public ResponseEntity<?> demoteToUser(@PathVariable String username) {
        try {
            User updatedUser = adminService.demoteAdmin(username);
            return ResponseEntity.ok(updatedUser);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


}
