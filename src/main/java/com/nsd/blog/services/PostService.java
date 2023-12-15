package com.nsd.blog.services;

import java.util.List;

import com.nsd.blog.dto.PostDto;

public interface PostService {

	PostDto createPost(PostDto dto);

	PostDto updatePost(PostDto postDto, Integer id);

	void deletePost(Integer id);

	List<PostDto> getAllPosts();

	PostDto getPostById(Integer id);

	List<PostDto> getPostsByBycategory(Integer catId);

	List<PostDto> getPostsByUser(Integer userId);

	List<PostDto> searchPosts(String keyword);

}
