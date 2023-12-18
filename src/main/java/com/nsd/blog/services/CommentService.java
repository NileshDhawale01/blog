package com.nsd.blog.services;

import com.nsd.blog.dto.CommentDto;

public interface CommentService {

	CommentDto createComment(CommentDto commentDto);
	
	void deleteCommentById(Integer commentId);
}
