package com.abreu.blog.service;
import com.abreu.blog.payload.PostDto;
import com.abreu.blog.payload.PostResponse;
import java.util.List;

public interface PostService {

    PostDto getPostById(int id);
/*
    List<PostDto> getPostsByCategory(int categoryId);
*/
    List<PostDto> getPostsByUser(int userId);
    List<PostDto> searchPosts(String keyword);
    PostResponse getAllPosts(int pageNumber, int pageSize, String sortBy, String sortDir);
    PostDto createPost(PostDto postDto,int userId);
    PostDto updatePost(int postId,PostDto postDto);
    void deletePost(int postId);
}
