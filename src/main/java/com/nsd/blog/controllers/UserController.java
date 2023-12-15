package com.nsd.blog.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nsd.blog.dto.UserDto;
import com.nsd.blog.services.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService  userService;
	
	@PostMapping("/save")
	public ResponseEntity<Map<Object, Object>> saveUser(@Valid @RequestBody UserDto dto){
		Map<Object, Object> map = new HashMap<>();
		map.put("data", userService.createUser(dto));
		map.put("success", true);
		return new ResponseEntity<>(map, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Map<Object, Object>> getUserById(@PathVariable Integer id){
		Map<Object, Object> map = new HashMap<>();
		map.put("data", userService.getUserById(id));
		map.put("success", true);
		return new ResponseEntity<>(map, HttpStatus.OK);
	}
	
	@GetMapping("/all")
	public ResponseEntity<Map<Object, Object>> getAllUser(){
		Map<Object, Object> map = new HashMap<>();
		map.put("data", userService.getAllUser());
		map.put("success", true);
		return new ResponseEntity<>(map, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Map<Object, Object>> deleteUser(@PathVariable Integer id){
		Map<Object, Object> map = new HashMap<>();
		userService.deleteUser(id);
		map.put("data", "User Deleted Successfully.");
		map.put("success", true);
		return new ResponseEntity<>(map, HttpStatus.OK);
	}
}
