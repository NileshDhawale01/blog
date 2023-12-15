package com.nsd.blog.mappers;

import static com.nsd.blog.utils.CollectionUtil.newList;
import static com.nsd.blog.utils.FunctionUtil.evalMapper;
import static com.nsd.blog.utils.FunctionUtil.evalMapperCollection;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import com.nsd.blog.dto.UserDto;
import com.nsd.blog.entities.User;

public class UserMapper {

	private UserMapper() {
	}

	public static final Function<UserDto, Optional<User>> toUser = e -> evalMapper(e, User.class);

	public static final Function<User, Optional<UserDto>> toUserDto = e -> evalMapper(e, UserDto.class);

	public static final Function<Collection<UserDto>, List<User>> toUsers = e -> newList(
			evalMapperCollection(e, User.class));

	public static final Function<Collection<User>, List<UserDto>> toUserDtos = e -> newList(
			evalMapperCollection(e, UserDto.class));

}
