package com.abreu.blog.controller;
import com.abreu.blog.config.AppConstants;
import com.abreu.blog.payload.ApiResponse;
import com.abreu.blog.payload.CommentDTO;
import com.abreu.blog.payload.CommentResponse;
import com.abreu.blog.service.CommentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class CommentController {

    private CommentService commentService;

    @PostMapping("/post/{postId}/comments/user/{userId}")
    public ResponseEntity<CommentDTO> createComment(@RequestBody CommentDTO commentDTO, @PathVariable int postId, @PathVariable int userId) {

        CommentDTO createComment = this.commentService.createComment(commentDTO, postId, userId);
        return new ResponseEntity<>(createComment, HttpStatus.CREATED);
    }

    @DeleteMapping("/comments/{commentId}")
    public ResponseEntity<ApiResponse> deleteComment(@PathVariable int commentId) {

        this.commentService.deleteComment(commentId);
        return new ResponseEntity<>(new ApiResponse("Comment deleted successfully",true), HttpStatus.OK);
    }

    @GetMapping("/comments")
    public ResponseEntity<CommentResponse> getAllComments
            (@RequestParam(value = "pageNumber", defaultValue = AppConstants.PAGE_NUMBER, required = false) int pageNumber,
             @RequestParam(value = "pageSize", defaultValue = AppConstants.PAGE_SIZE, required = false) int pageSize,
             @RequestParam(value = "sortBy",defaultValue = AppConstants.SORT_BY,required = false) String sortBy,
             @RequestParam(value = "sortDir",defaultValue = AppConstants.SORT_DIR,required = false) String sortDir // descentente
    ) {
        CommentResponse commentResponse = this.commentService.getAllComments(pageNumber,pageSize,sortBy,sortDir); //pageNumber começa no 0!!
        return new ResponseEntity<>(commentResponse, HttpStatus.OK);
    }

}
