package com.abreu.blog.service;
import com.abreu.blog.exceptions.ResourceNotFoundException;
import com.abreu.blog.model.Comment;
import com.abreu.blog.model.Post;
import com.abreu.blog.payload.CommentDTO;
import com.abreu.blog.repository.CommentRepository;
import com.abreu.blog.repository.PostRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CommentServiceImpl implements CommentService {

    private PostRepository postRepo;
    private CommentRepository commentRepo;
    private ModelMapper modelMapper;

    @Override
    public CommentDTO createComment(CommentDTO commentDTO, int postId) {

        Post post = this.postRepo.findById(postId)
                .orElseThrow(() -> new ResourceNotFoundException("Post", "id", postId));

        Comment comment = this.modelMapper.map(commentDTO, Comment.class);

        comment.setPost(post);
        Comment savedComment = this.commentRepo.save(comment);
        return this.modelMapper.map(savedComment, CommentDTO.class);
    }

    @Override
    public void deleteComment(int commentId) {

        Comment comment = this.commentRepo.findById(commentId)
                .orElseThrow(() -> new ResourceNotFoundException("Comment", "id", commentId));

        this.commentRepo.delete(comment);
    }
}
