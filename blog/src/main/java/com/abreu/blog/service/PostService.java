package com.abreu.blog.service;

import com.abreu.blog.payload.PostDto;
import java.util.List;

public interface PostService {

    PostDto getPostById(int id);
    List<PostDto> getPostsByCategory(int categoryId);
    List<PostDto> getPostsByUser(int userId);
    List<PostDto> searchPosts(String keyword);
    List<PostDto> getAllPosts();
    PostDto createPost(PostDto postDto,int userId,int categoryId);
    PostDto updatePost(int postId,PostDto postDto);
    void deletePost(int postId);


}
