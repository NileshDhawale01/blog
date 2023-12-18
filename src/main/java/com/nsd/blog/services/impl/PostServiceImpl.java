package com.nsd.blog.services.impl;

import static com.nsd.blog.mappers.PostMapper.toPost;
import static com.nsd.blog.mappers.PostMapper.toPostDto;
import static com.nsd.blog.mappers.PostMapper.toPostDtos;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nsd.blog.dto.PostDto;
import com.nsd.blog.entities.Category;
import com.nsd.blog.entities.User;
import com.nsd.blog.exceptions.ResourceNotFoundException;
import com.nsd.blog.repositories.CategoryRepo;
import com.nsd.blog.repositories.PostRepo;
import com.nsd.blog.repositories.UserRepo;
import com.nsd.blog.services.PostService;

@Service
public class PostServiceImpl implements PostService{

	
	@Autowired
	private PostRepo postRepo;
	
	@Autowired
	private CategoryRepo categoryRepo;
	
	@Autowired
	private UserRepo userRepo;
	
	@Override
	public PostDto createPost(PostDto dto) {
		dto.setAddedDate(new Date());
		// here may be we face issue
		// when we save post then respective 
		//user data and category data become null!!
		return toPostDto.apply(postRepo.save(toPost.apply(dto).get())).get();
		
		/*
		 * Post post = toPost.apply(dto).get();
		 * post.setCategory(toCategory.apply(dto.getCategoryDto()).get()); return
		 * toPostDto.apply(postRepo.save(post));
		 */
	}

	@Override
	public PostDto updatePost(PostDto postDto, Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deletePost(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<PostDto> getAllPosts() {
		return toPostDtos.apply(postRepo.findAll());
	}

	@Override
	public PostDto getPostById(Integer id) {
		return toPostDto.apply(postRepo.findById(id).get()).orElseThrow(()-> new ResourceNotFoundException("post","postId",id));
	}

	@Override
	public List<PostDto> getPostsByBycategory(Integer catId) {
		Category category = categoryRepo.findById(catId).orElseThrow(()->new ResourceNotFoundException("category", "categoryId", catId));
		List<PostDto> posts = toPostDtos.apply(postRepo.findByCategory(category));
		return posts;
	}

	@Override
	public List<PostDto> getPostsByUser(Integer userId) {
		User user = userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("user","userId",userId));
		return toPostDtos.apply(postRepo.findByUser(user));
	}

	@Override
	public List<PostDto> searchPosts(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

}
