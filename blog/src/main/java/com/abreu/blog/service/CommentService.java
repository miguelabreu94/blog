package com.abreu.blog.service;
import com.abreu.blog.payload.CommentDTO;
import com.abreu.blog.payload.CommentResponse;

public interface CommentService {

    CommentResponse getAllComments(int pageNumber, int pageSize, String sortBy, String sortDir);
    CommentDTO createComment(CommentDTO commentDTO, int postId, int userId);
    void deleteComment(int commentId);
}
