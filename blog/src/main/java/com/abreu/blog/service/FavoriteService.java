package com.abreu.blog.service;

import com.abreu.blog.model.Post;
import com.abreu.blog.model.User;
import com.abreu.blog.model.Favorite;
import com.abreu.blog.payload.PostDto;
import com.abreu.blog.repository.FavoriteRepository;
import com.abreu.blog.repository.PostRepository;
import com.abreu.blog.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class FavoriteService {

    @Autowired
    private FavoriteRepository favoriteRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Transactional
    public void addFavorite(int userId, int postId) {
        User user = userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("User not found"));

        Post post = postRepository.findById(postId).orElseThrow(() -> new IllegalArgumentException("Post not found"));

        Favorite userFavoritePost = new Favorite();
        userFavoritePost.setUser(user);
        userFavoritePost.setPost(post);
        userFavoritePost.setDateAdded(LocalDateTime.now());
        favoriteRepository.save(userFavoritePost);
    }

    @Transactional
    public void removeFavorite(int userId, int postId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new IllegalArgumentException("Post not found"));

        Favorite favorite = favoriteRepository.findByUserAndPost(user, post).orElseThrow(() -> new IllegalArgumentException("Favorite not found"));
        favoriteRepository.delete(favorite);
    }

    public boolean isFavorite(int userId, int postId) {
        User user = userRepository.findById(userId).orElse(null);
        Post post = postRepository.findById(postId).orElse(null);
        if (user == null || post == null) {
            return false;
        }
        return favoriteRepository.findByUserAndPost(user, post).isPresent();
    }

    public long countFavoritesByPost(int postId) {
        Post post = postRepository.findById(postId).orElse(null);
        if (post == null) {
            return 0;
        }
        return favoriteRepository.countByPost(post);
    }

    public List<PostDto> getFavoritePostsByUser(int userId) {
        List<Favorite> favorites = favoriteRepository.findByUser_Id(userId);
        favorites.sort(Comparator.comparing(Favorite::getDateAdded).reversed());
        return favorites.stream()
                .map(favorite -> modelMapper.map(favorite.getPost(), PostDto.class))
                .collect(Collectors.toList());
    }
    public List<PostDto> getFavoritePostsByUserByNumberOfFav(int userId) {
        List<Favorite> favorites = favoriteRepository.findByUser_Id(userId);
        Map<Post, Long> postFavoriteCount = favorites.stream()
                .collect(Collectors.groupingBy(Favorite::getPost, Collectors.counting()));

        // Sort the posts based on the number of favorites in descending order
        List<Post> sortedPosts = postFavoriteCount.entrySet().stream()
                .sorted((e1, e2) -> Long.compare(e2.getValue(), e1.getValue())) // descending order by count
                .map(Map.Entry::getKey)
                .toList();

        return favorites.stream()
                .map(favorite -> modelMapper.map(favorite.getPost(), PostDto.class))
                .collect(Collectors.toList());
    }


}
