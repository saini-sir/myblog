package com.myblog.myblog.Post.service;

import com.myblog.myblog.payload.PostDto;

import java.util.List;

public interface PostService {
    PostDto CreatePost (PostDto postDto);

    PostDto getPostById(long id);

    List<PostDto> getAllPosts(int pageNo, int pageSize, String sortBy, String sortDir);
}
