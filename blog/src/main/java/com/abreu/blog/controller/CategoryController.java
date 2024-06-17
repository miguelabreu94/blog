package com.abreu.blog.controller;
import com.abreu.blog.model.Category;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class CategoryController {

    @CrossOrigin(origins = "http://localhost:3000/")
    @GetMapping("/category/all")
    public ResponseEntity<Category[]> getAllCategories() {
        return ResponseEntity.ok(Category.values());
    }
}
