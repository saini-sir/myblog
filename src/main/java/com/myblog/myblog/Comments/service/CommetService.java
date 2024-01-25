package com.myblog.myblog.Comments.service;

import com.myblog.myblog.payload.CommentDto;

public interface CommetService {
    CommentDto createComment(CommentDto commentDto, Long postId);
}
