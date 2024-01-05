package com.myblog.myblog.controller;

import com.myblog.myblog.payload.PostDto;
import com.myblog.myblog.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostController {

    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }
    @PostMapping("/api/posts")
    public ResponseEntity<PostDto> CreatePost(@RequestBody PostDto postDto){
       PostDto dto =  postService.CreatePost(postDto);
       return  new ResponseEntity<>(dto, HttpStatus.CREATED);
    }
}
