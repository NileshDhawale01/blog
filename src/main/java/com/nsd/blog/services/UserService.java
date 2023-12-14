package com.nsd.blog.services;

import java.util.List;

import com.nsd.blog.dto.UserDto;

public interface UserService {

	UserDto createUser(UserDto userDto);
	
	UserDto updateUser(UserDto dto , Integer userId);
	
	UserDto getUserById(Integer userId);
	
	List<UserDto> getAllUser();
	
	void deleteUser(Integer userId);
}
