package com.nsd.blog.services.impl;

import static com.nsd.blog.mappers.UserMapper.toUser;
import static com.nsd.blog.mappers.UserMapper.toUserDto;
import static com.nsd.blog.mappers.UserMapper.toUserDtos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nsd.blog.dto.UserDto;
import com.nsd.blog.entities.User;
import com.nsd.blog.exceptions.ResourceNotFoundException;
import com.nsd.blog.repositories.UserRepo;
import com.nsd.blog.services.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo;

	@Override
	public UserDto createUser(UserDto userDto) {
		return toUserDto.apply(userRepo.save(toUser.apply(userDto).get())).get();
	}

	@Override
	public UserDto updateUser(UserDto dto, Integer userId) {
		User user = userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("user", "userId", userId));
		user.setName(dto.getName());
		user.setAbout(dto.getAbout());
		user.setEmail(dto.getEmail());
		user.setPassword(dto.getPassword());
		return toUserDto.apply(userRepo.save(user)).get();

	}

	@Override
	public UserDto getUserById(Integer userId) {
		return toUserDto.apply(userRepo.findById(userId).get())
				.orElseThrow(() -> new ResourceNotFoundException("username", "userId", userId));
	}

	@Override
	public List<UserDto> getAllUser() {
		List<User> list = userRepo.findAll();
		return toUserDtos.apply(list);
	}

	@Override
	public void deleteUser(Integer userId) {
		User user = userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("user", "userId", userId));
		userRepo.delete(user);
	}
}
