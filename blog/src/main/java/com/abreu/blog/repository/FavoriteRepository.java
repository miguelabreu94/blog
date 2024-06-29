package com.abreu.blog.repository;

import com.abreu.blog.model.Post;
import com.abreu.blog.model.User;
import com.abreu.blog.model.Favorite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface FavoriteRepository extends JpaRepository<Favorite, Integer> {
    List<Favorite> findByUser(User user);
    List<Favorite> findByUser_Id(int userId);
    List<Favorite> findByPost(Post post);
    Optional<Favorite> findByUserAndPost(User user, Post post);
    long countByPost(Post post);

}
