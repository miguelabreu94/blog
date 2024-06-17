package com.abreu.blog.repository;
import com.abreu.blog.model.Role;
import com.abreu.blog.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    Optional<User> findByUsername(String username);

    boolean existsByUsername(String username);

    Optional<User> findByRole(Role role);
}
