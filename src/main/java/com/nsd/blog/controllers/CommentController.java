package com.nsd.blog.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nsd.blog.dto.CommentDto;
import com.nsd.blog.services.CommentService;

@RestController
@RequestMapping("/comment")
public class CommentController {

	@Autowired
	private CommentService commentService;

	@PostMapping("/add")
	public ResponseEntity<Map<Object, Object>> createComment(@RequestBody CommentDto commentDto) {

		Map<Object, Object> map = new HashMap<>();
		map.put("data", commentService.createComment(commentDto));
		map.put("success", true);
		return new ResponseEntity<>(map, HttpStatus.CREATED);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Map<Object, Object>> deleteComment(@PathVariable Integer id) {
		Map<Object, Object> map = new HashMap<>();
		map.put("data", "comment Deleted which Id is" + id);
		map.put("success", true);
		return new ResponseEntity<>(map, HttpStatus.OK);
	}
}
