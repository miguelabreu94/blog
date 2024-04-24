package com.abreu.blog.service;

import com.abreu.blog.payload.CategoryDto;

import java.util.List;

public interface CategoryService {
    CategoryDto createCategory(CategoryDto categoryDto);
    CategoryDto updateCategory(CategoryDto categoryDto, int id);
    CategoryDto getCategory(int categoryId);
    List<CategoryDto> getAllCategories();
    void deleteCategory(int categoryId);
}
