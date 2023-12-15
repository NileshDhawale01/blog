package com.nsd.blog.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nsd.blog.entities.Category;
import com.nsd.blog.entities.Post;
import com.nsd.blog.entities.User;

public interface PostRepo extends JpaRepository<Post, Integer> {

	List<Post> findByUser(User user);
	
	List<Post> findByCategory(Category category);
}
