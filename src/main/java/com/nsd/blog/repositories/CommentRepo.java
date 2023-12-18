package com.nsd.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nsd.blog.entities.Comment;

public interface CommentRepo extends JpaRepository<Comment, Integer> {

}
