package com.abreu.blog.controller;
import com.abreu.blog.config.AppConstants;
import com.abreu.blog.payload.ApiResponse;
import com.abreu.blog.payload.PostDto;
import com.abreu.blog.payload.PostResponse;
import com.abreu.blog.service.FileService;
import com.abreu.blog.service.FileServiceImpl;
import com.abreu.blog.service.PostService;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@RestController
public class PostController {

    @Value("${project.image}")
    private String path;

    @Autowired
    private PostService postService;
    @Autowired
    private FileService fileService;
    @Autowired
    private FileServiceImpl fileServiceImpl;

    @CrossOrigin(origins = "http://localhost:3000/")
    @PostMapping("/admin/{userId}/posts")
    public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto, @PathVariable int userId) {

        PostDto createPost = this.postService.createPost(postDto,userId);
        return new ResponseEntity<>(createPost, HttpStatus.CREATED);
    }

    @CrossOrigin(origins = "http://localhost:3000/")
    @GetMapping("/user/{userId}/posts")
    public ResponseEntity<List<PostDto>> getPostsByUser(@PathVariable int userId){

        List<PostDto> posts = this.postService.getPostsByUser(userId);
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }

   /* @CrossOrigin(origins = "http://localhost:3000/")
    @GetMapping("/category/{categoryId}/posts")
    public ResponseEntity<List<PostDto>> getPostsByCategory(@PathVariable int categoryId){

        List<PostDto> posts = this.postService.getPostsByCategory(categoryId);
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }*/

    @CrossOrigin(origins = "http://localhost:3000/")
    @GetMapping("/posts")
    public ResponseEntity<PostResponse> getAllPost(
             @RequestParam(value = "pageNumber", defaultValue = AppConstants.PAGE_NUMBER, required = false) int pageNumber,
             @RequestParam(value = "pageSize", defaultValue = AppConstants.PAGE_SIZE, required = false) int pageSize,
             @RequestParam(value = "sortBy",defaultValue = AppConstants.SORT_BY,required = false) String sortBy,
             @RequestParam(value = "sortDir",defaultValue = AppConstants.SORT_DIR,required = false) String sortDir // descentente
             ) {

        PostResponse postResponse = this.postService.getAllPosts(pageNumber,pageSize,sortBy,sortDir); //pageNumber começa no 0!!
        return new ResponseEntity<>(postResponse, HttpStatus.OK);
    }

    @GetMapping("/posts/{postId}")
    public ResponseEntity<PostDto> getPostById(@PathVariable int postId){

        PostDto postDto = this.postService.getPostById(postId);
        return new ResponseEntity<>(postDto, HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:3000/")
    @DeleteMapping("/posts/{postId}")
    public ResponseEntity<ApiResponse> deletePost(@PathVariable int postId){

        this.postService.deletePost(postId);
        return new ResponseEntity<>(new ApiResponse("Post deleted successfully",true), HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:3000/")
    @PutMapping("/posts/{postId}")
    public ResponseEntity<PostDto> updatePost(@PathVariable int postId, @RequestBody PostDto postDto){

        PostDto updatePost = this.postService.updatePost(postId,postDto);
        return new ResponseEntity<>(updatePost, HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:3000/")
    @GetMapping("posts/{postId}/{slug}")
    public ResponseEntity<PostDto> getPostBySlug(@PathVariable Long postId, @PathVariable String slug){

        PostDto postDto = postService.getPostBySlug(postId, slug);
        return new ResponseEntity<>(postDto, HttpStatus.OK);
    }

    @PostMapping("/post/image/upload/{postId}")
    public ResponseEntity<PostDto> uploadPostImage(@RequestParam("image") MultipartFile image, @PathVariable int postId) throws IOException {

        PostDto postDto = this.postService.getPostById(postId);

        String fileName = this.fileService.uploadImage(path,image);
        postDto.setImageName(fileName);
        PostDto updatePost = this.postService.updatePost(postId,postDto);

        return new ResponseEntity<>(updatePost, HttpStatus.OK);
    }

    @GetMapping(value = "/post/image/{imageName}", produces = MediaType.IMAGE_JPEG_VALUE)
    public void downloadImage(@PathVariable("imageName") String imageName, HttpServletResponse response) throws IOException{

        InputStream resource = this.fileService.getResource(path,imageName);
        response.setContentType(MediaType.IMAGE_JPEG_VALUE);
        StreamUtils.copy(resource,response.getOutputStream());
    }

}
