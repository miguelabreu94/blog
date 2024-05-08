package com.abreu.blog.service;
import com.abreu.blog.payload.CommentDTO;


public interface CommentService {

    CommentDTO createComment(CommentDTO commentDTO, int postId);
    void deleteComment(int commentId);
}
