package com.myblog.myblog.Comments.CommentController;

import com.myblog.myblog.payload.CommentDto;
import com.myblog.myblog.Comments.service.CommetService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CommentController {

    private CommetService commetService;

    public CommentController(CommetService commetService) {
        this.commetService = commetService;
    }

    // http://localhost:8080/api/saveComment?postId=1
    @PostMapping("/saveComment")
    public ResponseEntity<CommentDto> createComment(
            @RequestParam Long postId,
            @RequestBody CommentDto commentDto){
       CommentDto dto =  commetService.createComment(commentDto,postId);
       return  new ResponseEntity<>(dto, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteComment(@PathVariable long id){
        commetService.deleteComment(id);
        return  new ResponseEntity<>("Record is deleted",HttpStatus.OK);
    }
   //  http://localhost:8080/api/update/3/post/1
    @PutMapping("/update/{id}/post/{postId}")
    public ResponseEntity<CommentDto> updateComment(
            @PathVariable long id,
            @PathVariable long postId,
            @RequestBody CommentDto commentDto){
       CommentDto dto = commetService.updateComment(id,commentDto,postId);
        return new ResponseEntity<>(dto,HttpStatus.OK);
    }

}
