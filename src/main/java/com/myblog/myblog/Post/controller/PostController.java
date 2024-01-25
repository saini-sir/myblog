package com.myblog.myblog.Post.controller;
import com.myblog.myblog.payload.PostDto;
import com.myblog.myblog.Post.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {
// http://localhost:8080/swagger-ui/index.html
    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }
    @PostMapping("/save")
    public ResponseEntity<PostDto> CreatePost(@RequestBody PostDto postDto){
       PostDto dto =  postService.CreatePost(postDto);
       return  new ResponseEntity<>(dto, HttpStatus.CREATED);
    }
    // http://localhost:8080/api/posts/particular?id=1
    @GetMapping("/particular")
    public ResponseEntity <PostDto> findPostById(@RequestParam long id){
       PostDto dto =  postService.getPostById(id);
       return  new ResponseEntity<>(dto, HttpStatus.OK);
    }
    //http://localhost:8080/api/posts/all?pageNo=0&pageSize=3&sortBy=title&sortDir
    @GetMapping("/all")
    public List<PostDto> getAllPosts(
            @RequestParam (name = "pageNo", required = false ,defaultValue = "0") int pageNo,
            @RequestParam (name = "pageSize", required = false, defaultValue = "3") int pageSize,
            @RequestParam (name = "sortBy", required = false ,defaultValue = "id") String sortBy,
            @RequestParam (name = "sortDir", required = false ,defaultValue = "id") String sortDir

    ){

        List<PostDto> dtos = postService.getAllPosts(pageNo , pageSize, sortBy, sortDir);
        return dtos;
    }


}
