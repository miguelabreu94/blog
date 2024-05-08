package com.abreu.blog.controller;
import com.abreu.blog.payload.ApiResponse;
import com.abreu.blog.payload.CommentDTO;
import com.abreu.blog.service.CommentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class CommentController {

    private CommentService commentService;

    @PostMapping("/post/{postId}/comments")
    public ResponseEntity<CommentDTO> createComment(@RequestBody CommentDTO commentDTO, @PathVariable int postId) {

        CommentDTO createComment = this.commentService.createComment(commentDTO, postId);
        return new ResponseEntity<>(createComment, HttpStatus.CREATED);
    }

    @DeleteMapping("/comments/{commentId}")
    public ResponseEntity<ApiResponse> deleteComment(@PathVariable int commentId) {

        this.commentService.deleteComment(commentId);
        return new ResponseEntity<>(new ApiResponse("Comment deleted successfully",true), HttpStatus.OK);
    }



}
