package com.abreu.blog.controller;
import com.abreu.blog.payload.PostDto;
import com.abreu.blog.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/favorites")
public class FavoriteController {

    @Autowired
    private FavoriteService favoriteService;

    @CrossOrigin(origins = "http://localhost:3000/")
    @PostMapping("/add")
    public ResponseEntity<?> addFavorite(@RequestParam int userId, @RequestParam int postId) {
        favoriteService.addFavorite(userId, postId);
        return ResponseEntity.ok().build();
    }

    @CrossOrigin(origins = "http://localhost:3000/")
    @DeleteMapping("/remove")
    public ResponseEntity<?> removeFavorite(@RequestParam int userId, @RequestParam int postId) {
        favoriteService.removeFavorite(userId, postId);
        return ResponseEntity.ok().build();
    }

    @CrossOrigin(origins = "http://localhost:3000/")
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<PostDto>> getFavoritesByDateAdded(@PathVariable int userId) {
        List<PostDto> favoritePosts = favoriteService.getFavoritePostsByUser(userId);
        return ResponseEntity.ok(favoritePosts);
    }


    @CrossOrigin(origins = "http://localhost:3000/")
    @GetMapping("/user/{userId}/mostfav")
    public ResponseEntity<List<PostDto>> getFavouritePostsByNumberOfFav(@PathVariable int userId) {
        List<PostDto> favoritePosts = favoriteService.getFavoritePostsByUserByNumberOfFav(userId);
        return ResponseEntity.ok(favoritePosts);
    }

    @CrossOrigin(origins = "http://localhost:3000/")
    @GetMapping("/check")
    public ResponseEntity<Map<String, Boolean>> checkFavorite(@RequestParam int userId, @RequestParam int postId) {
        boolean isFavorite = favoriteService.isFavorite(userId, postId);
        Map<String, Boolean> response = new HashMap<>();
        response.put("isFavorite", isFavorite);
        return ResponseEntity.ok(response);
    }

    @CrossOrigin(origins = "http://localhost:3000/")
    @GetMapping("/count")
    public ResponseEntity<Map<String, Long>> countFavoritesByPost(@RequestParam int postId) {
        long favoriteCount = favoriteService.countFavoritesByPost(postId);
        Map<String, Long> response = new HashMap<>();
        response.put("favoriteCount", favoriteCount);
        return ResponseEntity.ok(response);
    }


}
