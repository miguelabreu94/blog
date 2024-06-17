package com.abreu.blog.controller;
import com.abreu.blog.payload.CategoryDto;
import com.abreu.blog.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@AllArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @CrossOrigin(origins = "http://localhost:3000/")
    @GetMapping("/category/{id}")
    public ResponseEntity<CategoryDto> getCategory(@PathVariable int id) {
        CategoryDto categoryDto = categoryService.getCategory(id);
        return new ResponseEntity<>(categoryDto, HttpStatus.OK);
    }
    @CrossOrigin(origins = "http://localhost:3000/")
    @GetMapping("/category")
    public ResponseEntity<List<CategoryDto>> getAll() {
        return ResponseEntity.ok(this.categoryService.getAllCategories());
    }

    @PostMapping("/category")
    public ResponseEntity<CategoryDto> createCategory(@RequestBody CategoryDto categoryDto) {
        CategoryDto createCategory = this.categoryService.createCategory(categoryDto);
        return new ResponseEntity<>(createCategory, HttpStatus.CREATED);
    }

    @PutMapping("/category/{id}")
    public ResponseEntity<CategoryDto> updateCategory(@PathVariable int id, @RequestBody CategoryDto categoryDto) {
        CategoryDto updatedCategory = this.categoryService.updateCategory(categoryDto,id);
        return new ResponseEntity<>(updatedCategory, HttpStatus.OK);
    }

    @DeleteMapping("/category/{id}")
    public void deleteCategory(@PathVariable int id) {
        categoryService.deleteCategory(id);
    }
}