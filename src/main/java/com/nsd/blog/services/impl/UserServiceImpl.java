package com.nsd.blog.services.impl;

import java.util.List;
import java.util.stream.Collectors;

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
		User user = dtoToEntity(userDto);
		return entityToDto(userRepo.save(user));
	}

	@Override
	public UserDto updateUser(UserDto dto, Integer userId) {
		User user = userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("user", "userId", userId));
		user.setName(dto.getName());
		user.setAbout(dto.getAbout());
		user.setEmail(dto.getEmail());
		user.setPassword(dto.getPassword());
		return entityToDto(userRepo.save(user));

	}

	@Override
	public UserDto getUserById(Integer userId) {
		return entityToDto(
				userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("user", "userId", userId)));
	}

	@Override
	public List<UserDto> getAllUser() {
		List<User> list = userRepo.findAll();
		List<UserDto> userDto = list.stream().map(l -> entityToDto(l)).collect(Collectors.toList());
		return userDto;
	}

	@Override
	public void deleteUser(Integer userId) {
		User user = userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("user", "userId", userId));
		userRepo.delete(user);
	}

	// let run fast
	private User dtoToEntity(UserDto dto) {
		User user = new User();
		user.setId(dto.getId());
		user.setAbout(dto.getAbout());
		user.setEmail(dto.getEmail());
		user.setName(dto.getPassword());
		user.setPassword(dto.getPassword());
		return user;
	}

	private UserDto entityToDto(User user) {
		UserDto userDto = new UserDto();
		userDto.setId(user.getId());
		userDto.setAbout(user.getAbout());
		userDto.setEmail(user.getEmail());
		userDto.setName(user.getPassword());
		userDto.setPassword(user.getPassword());
		return userDto;
	}
}
