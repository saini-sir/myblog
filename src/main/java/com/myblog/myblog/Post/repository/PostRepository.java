package com.myblog.myblog.Post.repository;

import com.myblog.myblog.Post.Entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
