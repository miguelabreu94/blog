package com.abreu.blog.repository;
import com.abreu.blog.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface CommentRepository extends JpaRepository<Comment, Integer> {

    void deleteByPostId(int postId);


}
