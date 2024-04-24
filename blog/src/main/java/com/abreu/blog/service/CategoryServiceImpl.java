package com.abreu.blog.service;

import com.abreu.blog.exceptions.ResourceNotFoundException;
import com.abreu.blog.model.Category;
import com.abreu.blog.payload.CategoryDto;
import com.abreu.blog.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository categoryRepository;
    private ModelMapper modelMapper;

    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {

        Category category = dtoToCategory(categoryDto);
        Category addedCat = this.categoryRepository.save(category);

        return this.categoryToDto(addedCat);
    }

    @Override
    public CategoryDto updateCategory(CategoryDto categoryDto, int id) {

        Category category = this.categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category", "Category Id", id));
        category.setCategoryTitle(categoryDto.getCategoryTitle());
        category.setCategoryDescription(categoryDto.getCategoryDescription());

        Category updatedCat = this.categoryRepository.save(category);
        return this.categoryToDto(updatedCat);
    }

    @Override
    public CategoryDto getCategory(int categoryId) {

        Category category = this.categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category", "Category Id", categoryId));

        return this.categoryToDto(category);
    }

    @Override
    public List<CategoryDto> getAllCategories() {

        List<Category> categories = this.categoryRepository.findAll();

        return categories.stream().map(this::categoryToDto).toList();
    }

    @Override
    public void deleteCategory(int categoryId) {

        Category cat = this.categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category", "Category Id", categoryId));
        this.categoryRepository.delete(cat);
    }

    public Category dtoToCategory(CategoryDto categoryDto){
        return this.modelMapper.map(categoryDto,Category.class);
    }

    public CategoryDto categoryToDto(Category category){
        return this.modelMapper.map(category,CategoryDto.class);
    }

}
