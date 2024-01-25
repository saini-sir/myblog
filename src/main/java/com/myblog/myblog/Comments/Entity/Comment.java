package com.myblog.myblog.Comments.Entity;

import com.myblog.myblog.Post.Entity.Post;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "comments")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String text;
    private String email;


    @ManyToOne
    @JoinColumn(name="post_id")
    private Post post;
}
