package com.abreu.blog.repository;
import com.abreu.blog.model.Post;
import com.abreu.blog.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<Post,Integer> {

    List<Post> findAllByUser(User user);
    List<Post> findByTitleContaining(String title);
    Optional<Post> findByIdAndSlug(Long id, String slug);

}
