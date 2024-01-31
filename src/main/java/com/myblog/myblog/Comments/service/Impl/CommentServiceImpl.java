package com.myblog.myblog.Comments.service.Impl;

import com.myblog.myblog.Comments.Entity.Comment;
import com.myblog.myblog.Comments.Repository.CommentRepository;
import com.myblog.myblog.Post.Entity.Post;
import com.myblog.myblog.Post.repository.PostRepository;
import com.myblog.myblog.exception.ResourceNotFoundException;
import com.myblog.myblog.payload.CommentDto;
import com.myblog.myblog.Comments.service.CommetService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommetService {

    private final CommentRepository commentRepository;
    private final PostRepository postRepository;

    private final ModelMapper modelMapper;

    public CommentServiceImpl(CommentRepository commentRepository, PostRepository postRepository, ModelMapper modelMapper) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public CommentDto createComment(CommentDto commentDto, Long postId) {
        Post post = postRepository.findById(postId).orElseThrow(() -> new
                ResourceNotFoundException("Post NOt Found with id:" + postId));
        Comment comment = new Comment();
        comment.setEmail(commentDto.getEmail());
        comment.setText(commentDto.getText());
        comment.setPost(post);
        Comment saveComment = commentRepository.save(comment);

        CommentDto dto = new CommentDto();
        dto.setEmail(saveComment.getEmail());
        dto.setText(saveComment.getText());
        dto.setId(saveComment.getId());
        return dto;
    }

    @Override
    public void deleteComment(long id) {
        commentRepository.deleteById(id);
    }

    @Override
    public CommentDto updateComment(long id, CommentDto commentDto,long postId) {
        Comment commentId = commentRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Recored not found with id:" + id));
        Post pId = postRepository.findById(postId).orElseThrow(() -> new ResourceNotFoundException("Recored not found with postId:" + postId));

        Comment c = modelMapper.map(commentDto, Comment.class);
        c.setId(commentId.getId());
        c.setPost(pId);
        Comment updateComment = commentRepository.save(c);
        CommentDto dto = modelMapper.map(updateComment, CommentDto.class);
        return dto;
    }
    //Comment c =mapToEntity(commentDto);
//c.setId(comment.getId());
//Comment savedC = commentRepository.save(c);
//return mapToDto(savedC);
//}

//    CommentDto mapToDto(Comment comment){
//        CommentDto dto = modelMapper.map(comment, CommentDto.class);
//        return  dto;
//    }
//    Comment mapToEntity(CommentDto commentDto){
//       Comment comment= modelMapper.map(commentDto , Comment.class);
//       return  comment;
//    }
}
