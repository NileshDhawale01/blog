package com.nsd.blog.mappers;

import static com.nsd.blog.mappers.CategoryMapper.toCategory;
import static com.nsd.blog.mappers.CategoryMapper.toCategoryDto;
import static com.nsd.blog.mappers.UserMapper.toUser;
import static com.nsd.blog.mappers.UserMapper.toUserDto;
import static com.nsd.blog.utils.FunctionUtil.evalMapper;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import com.nsd.blog.dto.PostDto;
import com.nsd.blog.entities.Post;

public class PostMapper {

	private PostMapper() {
	}

	public static final Function<Post, Optional<PostDto>> toPostDto = e -> {
		Optional<PostDto> postDto = evalMapper(e, PostDto.class);

		postDto.ifPresent(p -> {
			p.setCategoryDto(toCategoryDto.apply(e.getCategory()).get());
		});

		postDto.ifPresent(p -> {
			p.setUserDto(toUserDto.apply(e.getUser()).get());
		});

		return postDto;
	};

	public static final Function<PostDto, Optional<Post>> toPost = e -> {
		Optional<Post> post = evalMapper(e, Post.class);

		post.ifPresent(p -> {
			p.setCategory(toCategory.apply(e.getCategoryDto()).get());
		});

		post.ifPresent(p -> {
			p.setUser(toUser.apply(e.getUserDto()).get());
		});

		return post;
	};

	public static final Function<Collection<Post>, List<PostDto>> toPostDtos = e -> {
		return e.stream().map(p -> toPostDto.apply(p).get()).collect(Collectors.toList());
	};

	public static final Function<Collection<PostDto>, List<Post>> toPosts = e -> {
		return e.stream().map(p -> toPost.apply(p).get()).collect(Collectors.toList());
	};
}
