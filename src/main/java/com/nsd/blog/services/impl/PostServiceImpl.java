package com.nsd.blog.services.impl;

import static com.nsd.blog.mappers.PostMapper.toPost;
import static com.nsd.blog.mappers.PostMapper.toPostDto;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nsd.blog.dto.PostDto;
import com.nsd.blog.repositories.PostRepo;
import com.nsd.blog.services.PostService;

@Service
public class PostServiceImpl implements PostService{

	
	@Autowired
	private PostRepo postRepo;
	
	@Override
	public PostDto createPost(PostDto dto) {
		dto.setAddedDate(new Date());
		// here may be we face issue
		// when we save post then respective 
		//user data and category data become null!!
		return toPostDto.apply(postRepo.save(toPost.apply(dto).get())).get();
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PostDto getPostById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PostDto> getPostsByBycategory(Integer catId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PostDto> getPostsByUser(Integer userId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PostDto> searchPosts(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

}
