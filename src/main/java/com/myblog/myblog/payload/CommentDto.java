package com.myblog.myblog.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Data
public class CommentDto {
    private  long id;
     private  String text;
     private String email;

}
