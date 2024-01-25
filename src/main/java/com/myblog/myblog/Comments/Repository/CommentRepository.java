package com.myblog.myblog.Comments.Repository;

import com.myblog.myblog.Comments.Entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment,Long> {
}
