package com.nsd.blog.services.impl;

import static com.nsd.blog.mappers.CommentMapper.toComment;
import static com.nsd.blog.mappers.CommentMapper.toCommentDto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nsd.blog.dto.CommentDto;
import com.nsd.blog.entities.Comment;
import com.nsd.blog.exceptions.ResourceNotFoundException;
import com.nsd.blog.repositories.CommentRepo;
import com.nsd.blog.services.CommentService;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentRepo commentRepo;

//	@Autowired
//	private PostRepo postRepo;

	@Override
	public CommentDto createComment(CommentDto commentDto) {

//		Integer postId = commentDto.getPostDto().getPostId();
//		Post post = postRepo.findById(postId).get();

		return toCommentDto.apply(commentRepo.save(toComment.apply(commentDto).get())).get();
	}

	@Override
	public void deleteCommentById(Integer commentId) {
		Comment comment = commentRepo.findById(commentId)
				.orElseThrow(() -> new ResourceNotFoundException("cooment", "commentId", commentId));
		commentRepo.delete(comment);
	}

}
