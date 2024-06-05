package com.abreu.blog.controller;
import com.abreu.blog.model.User;
import com.abreu.blog.service.AdminServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminServiceImpl adminService;

    @PostMapping("/promote/{username}")
    public ResponseEntity<?> promoteToAdmin(@PathVariable String username) {
        try {
            User updatedUser = adminService.promoteAdmin(username);
            return ResponseEntity.ok(updatedUser);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

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
