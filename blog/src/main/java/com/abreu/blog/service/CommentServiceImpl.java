package com.abreu.blog.service;
import com.abreu.blog.exceptions.ResourceNotFoundException;
import com.abreu.blog.model.Comment;
import com.abreu.blog.model.Post;
import com.abreu.blog.model.User;
import com.abreu.blog.payload.CommentDTO;
import com.abreu.blog.payload.CommentResponse;
import com.abreu.blog.repository.CommentRepository;
import com.abreu.blog.repository.PostRepository;
import com.abreu.blog.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class CommentServiceImpl implements CommentService {

    private PostRepository postRepo;
    private CommentRepository commentRepo;
    private ModelMapper modelMapper;
    private UserRepository userRepo;


    @Override
    public CommentResponse getAllComments(int pageNumber, int pageSize, String sortBy, String sortDir) {

        Sort sort ;
        if(sortDir.equalsIgnoreCase("des")) {
            sort = Sort.by(sortBy).descending();
        } else{
            sort = Sort.by(sortBy).ascending();
        }

        Pageable p = PageRequest.of(pageNumber,pageSize,sort);

        Page<Comment> pageComment =  this.commentRepo.findAll(p);
        List<Comment> allComments = pageComment.getContent();

        List<CommentDTO> commentDTOS = allComments.stream().map((comment) -> this.modelMapper.map(comment, CommentDTO.class)).toList();

        CommentResponse commentResponse = new CommentResponse();

        commentResponse.setContent(commentDTOS);
        commentResponse.setPageNumber(pageComment.getNumber());
        commentResponse.setPageSize(pageComment.getSize());
        commentResponse.setTotalElements(pageComment.getTotalElements());
        commentResponse.setTotalPages(pageComment.getTotalPages());
        commentResponse.setLastPage(pageComment.isLast());

        return commentResponse;
    }

    @Override
    public CommentDTO createComment(CommentDTO commentDTO, int postId, int userId) {

        Post post = this.postRepo.findById(postId)
                .orElseThrow(() -> new ResourceNotFoundException("Post", "id", postId));

        User user = this.userRepo.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", commentDTO.getUser().getId()));

        Comment comment = this.modelMapper.map(commentDTO, Comment.class);

        comment.setDateOfCreation(LocalDateTime.now());
        comment.setPost(post);
        comment.setUser(user);
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
