package com.nsd.blog.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nsd.blog.dto.PostDto;
import com.nsd.blog.services.PostService;

@RestController
@RequestMapping("/post")
public class PostController {

	
	@Autowired
	private PostService postService;
	
	@PostMapping("/create")
	public ResponseEntity<Map<Object, Object>> createPost(@RequestBody PostDto postDto){
		// here we may be we face issue 
		// all user and category data
		// become null --> for avoid pass userid 
		// and cat_id in pathvariable and change
		//sevice impl
		//find --> set --> save
		Map<Object, Object> map = new HashMap<>();
		map.put("data", postService.createPost(postDto));
		map.put("success", true);
		return new ResponseEntity<>(map, HttpStatus.CREATED);
	}
	// https://youtu.be/Uh-N_6Lccr4?si=0gI5NHU5-l52cEY2 
	// 5.41.50
}
