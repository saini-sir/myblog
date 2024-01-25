package com.myblog.myblog.Comments.CommentController;

import com.myblog.myblog.payload.CommentDto;
import com.myblog.myblog.Comments.service.CommetService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/comments")
public class CommentController {

    private CommetService commetService;

    public CommentController(CommetService commetService) {
        this.commetService = commetService;
    }

    // http://localhost:8080/api/comments?id=
    @PostMapping
    public ResponseEntity<CommentDto> createComment(
            @RequestParam Long postId,
            @RequestBody CommentDto commentDto){
       CommentDto dto =  commetService.createComment(commentDto,postId);
       return  new ResponseEntity<>(dto, HttpStatus.CREATED);
    }
}
