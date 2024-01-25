package com.myblog.myblog.Comments.service.Impl;

import com.myblog.myblog.Comments.Entity.Comment;
import com.myblog.myblog.Comments.Repository.CommentRepository;
import com.myblog.myblog.Post.Entity.Post;
import com.myblog.myblog.Post.repository.PostRepository;
import com.myblog.myblog.exception.ResourceNotFoundException;
import com.myblog.myblog.payload.CommentDto;
import com.myblog.myblog.Comments.service.CommetService;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommetService {

    private final CommentRepository commentRepository;
    private final PostRepository postRepository;


    public CommentServiceImpl(CommentRepository commentRepository, PostRepository postRepository) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
    }

    @Override
    public CommentDto createComment(CommentDto commentDto, Long postId) {
        Post post = postRepository.findById(postId).orElseThrow(()->new
                        ResourceNotFoundException("Post NOt Found with id:"+postId));
        Comment comment =new Comment();
        comment.setEmail(commentDto.getEmail());
        comment.setText(commentDto.getText());
        comment.setPost(post);
       Comment saveComment = commentRepository.save(comment);

       CommentDto dto  = new CommentDto();
       dto.setEmail(saveComment.getEmail());
       dto.setText(saveComment.getText());
       dto.setId(saveComment.getId());
       return  dto;
    }
}
