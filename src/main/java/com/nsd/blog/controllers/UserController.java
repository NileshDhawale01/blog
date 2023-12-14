package com.nsd.blog.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nsd.blog.dto.UserDto;
import com.nsd.blog.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService  userService;
	
	@PostMapping("/save")
	public ResponseEntity<Map<Object, Object>> saveUser(@RequestBody UserDto dto){
		Map<Object, Object> map = new HashMap<>();
		map.put("data", userService.createUser(dto));
		map.put("success", true);
		return new ResponseEntity<>(map, HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<Map<Object, Object>> getUserById(){
		Map<Object, Object> map = new HashMap<>();
		map.put("data", "working");
		map.put("success", true);
		return new ResponseEntity<>(map, HttpStatus.OK);
	}
}
