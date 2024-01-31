package com.myblog.myblog.Comments.service;

import com.myblog.myblog.payload.CommentDto;

public interface CommetService {
    CommentDto createComment(CommentDto commentDto, Long postId);

    void deleteComment(long id);

    CommentDto updateComment(long id, CommentDto commentDto,long postId);
}
