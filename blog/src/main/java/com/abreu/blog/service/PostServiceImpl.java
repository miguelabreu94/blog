package com.abreu.blog.service;

import com.abreu.blog.exceptions.ResourceNotFoundException;
import com.abreu.blog.model.Post;
import com.abreu.blog.model.User;
import com.abreu.blog.payload.PostDto;
import com.abreu.blog.repository.PostRepository;
import com.abreu.blog.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService{

    private PostRepository postRepository;
    private ModelMapper modelMapper;
    private UserRepository userRepository;

    @Override
    public PostDto getPostById(int id) {
        return null    ;
    }

    @Override
    public List<PostDto> getPostsByCategory(int categoryId) {
        return List.of();
    }

    @Override
    public List<PostDto> getPostsByUser(int userId) {
        return List.of();
    }

    @Override
    public List<PostDto> searchPosts(String keyword) {
        return List.of();
    }

    @Override
    public List<PostDto> getAllPosts() {
        return List.of();
    }

    @Override
    public PostDto createPost(PostDto postDto,int userId, int categoryId) {
        User user = this.userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));

        Post post = modelMapper.map(postDto, Post.class);
        return null;
    }

    @Override
    public PostDto updatePost(int postId, PostDto postDto) {
        return null;
    }

    @Override
    public void deletePost(int postId) {

    }
}
