package com.nsd.blog.mappers;

import static com.nsd.blog.mappers.PostMapper.toPost;
import static com.nsd.blog.mappers.PostMapper.toPostDto;
import static com.nsd.blog.mappers.UserMapper.toUser;
import static com.nsd.blog.mappers.UserMapper.toUserDto;
import static com.nsd.blog.utils.FunctionUtil.evalMapper;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.nsd.blog.dto.CommentDto;
import com.nsd.blog.entities.Comment;

public class CommentMapper {

	private CommentMapper() {
	}

	public static final Function<Comment, Optional<CommentDto>> toCommentDto = e -> {

		Optional<CommentDto> commentDto = evalMapper(e, CommentDto.class);

		commentDto.ifPresent(c -> {
			c.setPostDto(toPostDto.apply(e.getPost()).get());
		});

		commentDto.ifPresent(c -> {
			c.setUserDto(toUserDto.apply(e.getUser()).get());
		});

		return commentDto;
	};

	public static final Function<CommentDto, Optional<Comment>> toComment = e -> {
		Optional<Comment> comment = evalMapper(e, Comment.class);

		comment.ifPresent(c -> {
			c.setPost(toPost.apply(e.getPostDto()).get());
		});

		comment.ifPresent(c -> {
			c.setUser(toUser.apply(e.getUserDto()).get());
		});

		return comment;
	};

	public static final Function<Collection<Comment>, List<CommentDto>> toCommentDtos = e -> {
		return e.stream().map(c -> toCommentDto.apply(c).get()).collect(Collectors.toList());
	};

	public static final Function<Collection<CommentDto>, List<Comment>> toComments = e -> {
		return e.stream().map(c -> toComment.apply(c).get()).collect(Collectors.toList());
	};
}
