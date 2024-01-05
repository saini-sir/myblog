package com.myblog.myblog.service.impl;

import com.myblog.myblog.Entity.Post;
import com.myblog.myblog.payload.PostDto;
import com.myblog.myblog.repository.PostRepository;
import com.myblog.myblog.service.PostService;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {

    private PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }


    @Override
    public PostDto CreatePost(PostDto postDto) {
        Post  post = new Post();
        post.setTitle(postDto.getTitle());
        post.setDescription(postDto.getDescription());
        post.setContent(postDto.getContent());
       Post savedPost = postRepository.save(post);

       PostDto dto = new PostDto();
       dto.setTitle(savedPost.getTitle());
       dto.setDescription(savedPost.getDescription());
       dto.setContent(savedPost.getContent());
        return dto;
    }
}
