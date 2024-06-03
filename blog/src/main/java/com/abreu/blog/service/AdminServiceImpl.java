package com.abreu.blog.service;
import com.abreu.blog.model.Role;
import com.abreu.blog.model.User;
import com.abreu.blog.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AdminServiceImpl {

    private UserRepository userRepository;

    public User promoteAdmin(String username){
        User user = userRepository.findByUsername(username).orElseThrow();

        user.setRole(Role.ADMIN);
        return userRepository.save(user);
    }

    public User demoteAdmin(String username){
        User user = userRepository.findByUsername(username).orElseThrow();
        user.setRole(Role.USER);
        return userRepository.save(user);
    }

}
