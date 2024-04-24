package com.abreu.blog.repository;

import com.abreu.blog.model.Category;
import com.abreu.blog.model.Post;
import com.abreu.blog.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post,Integer> {

    List<Post> findAllByUser(User user);
    List<Post> findAllByCategory(Category category);
}
