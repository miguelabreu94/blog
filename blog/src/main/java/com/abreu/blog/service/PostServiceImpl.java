package com.abreu.blog.service;
import com.abreu.blog.exceptions.ResourceNotFoundException;
import com.abreu.blog.model.Category;
import com.abreu.blog.model.Post;
import com.abreu.blog.model.User;
import com.abreu.blog.payload.PostDto;
import com.abreu.blog.payload.PostResponse;
import com.abreu.blog.repository.CategoryRepository;
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
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PostServiceImpl implements PostService{

    private PostRepository postRepository;
    private ModelMapper modelMapper;
    private UserRepository userRepository;
    private CategoryRepository categoryRepository;

    @Override
    public PostDto getPostById(int postId) {

        Post post = this.postRepository.findById(postId)
                .orElseThrow(() -> new ResourceNotFoundException("Post", "id", postId));

        return this.modelMapper.map(post, PostDto.class);
    }

    @Override
    public List<PostDto> getPostsByCategory(int categoryId) {

        Category category = this.categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category", "category id", categoryId));
        List <Post> posts = this.postRepository.findAllByCategory(category);

        return posts.stream()
                .map((post) -> this.modelMapper.map(post, PostDto.class))
                .toList();
    }

    @Override
    public List<PostDto> getPostsByUser(int userId) {

        User user = this.userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));

        List<Post> posts = this.postRepository.findAllByUser(user);

        return posts.stream()
                .map(post -> modelMapper.map(post, PostDto.class))
                .toList();
    }

    @Override
    public List<PostDto> searchPosts(String keyword) {

       List<Post> posts = this.postRepository.findByTitleContaining(keyword);
       return posts.stream().map((post) -> this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
    }

    @Override
    public PostResponse getAllPosts(int pageNumber, int pageSize, String sortBy, String sortDir) {

         Sort sort ;
         if(sortDir.equalsIgnoreCase("asc")) {
             sort = Sort.by(sortBy).ascending();
         } else{
             sort = Sort.by(sortBy).descending();
         }

         Pageable p = PageRequest.of(pageNumber,pageSize,sort);

         Page<Post> pagePost =  this.postRepository.findAll(p);
         List<Post> allPosts = pagePost.getContent();

         List<PostDto> postDtos = allPosts.stream().map((post) -> this.modelMapper.map(post, PostDto.class)).toList();

         PostResponse postResponse = new PostResponse();

         postResponse.setContent(postDtos);
         postResponse.setPageNumber(pagePost.getNumber());
         postResponse.setPageSize(pagePost.getSize());
         postResponse.setTotalElements(pagePost.getTotalElements());
         postResponse.setTotalPages(pagePost.getTotalPages());
         postResponse.setLastPage(pagePost.isLast());

        return postResponse;
    }

    @Override
    public PostDto createPost(PostDto postDto,int userId, int categoryId) {
        User user = this.userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));

        Category category = this.categoryRepository.findById(categoryId)
                .orElseThrow(() -> new ResourceNotFoundException("Category", "id", categoryId));

        Post post = modelMapper.map(postDto, Post.class);
        post.setDateOfCreation(LocalDateTime.now());
        post.setUser(user);
        post.setCategory(category);

        Post newPost = this.postRepository.save(post);

        return this.modelMapper.map(newPost, PostDto.class);
    }

    @Override
    public PostDto updatePost(int postId, PostDto postDto) {

        Post post = this.postRepository.findById(postId)
                .orElseThrow(() -> new ResourceNotFoundException("Post", "id", postId));

        post.setTitle(postDto.getTitle());
        post.setContent(postDto.getContent());

        Post updatedPost = this.postRepository.save(post);

        return this.modelMapper.map(updatedPost, PostDto.class);
    }

    @Override
    public void deletePost(int postId) {

        Post post = this.postRepository.findById(postId)
                .orElseThrow(() -> new ResourceNotFoundException("Post", "id", postId));

        this.postRepository.delete(post);
    }
}
