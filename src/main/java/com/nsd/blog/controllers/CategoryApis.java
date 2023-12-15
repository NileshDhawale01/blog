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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nsd.blog.dto.CategoryDto;
import com.nsd.blog.services.CategoryService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/category")
public class CategoryApis {

	@Autowired
	private CategoryService categoryService;
	
	@PostMapping("/save")
	public ResponseEntity<Map<Object, Object>> saveCategory(@Valid @RequestBody CategoryDto categoryDto){
		Map<Object, Object> map = new HashMap<>();
		map.put("data", categoryService.saveCategory(categoryDto));
		map.put("success", true);
		return new ResponseEntity<>(map,HttpStatus.OK);
	}
	
	@GetMapping("/all")
	public ResponseEntity<Map<Object, Object>> getAllCategory(){
		Map<Object, Object> map = new HashMap<>();
		map.put("Data", categoryService.getAllCategorys());
		map.put("success", true);
		return new ResponseEntity<>(map, HttpStatus.OK);
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Map<Object, Object>> updateCategory(@Valid @RequestBody CategoryDto categoryDto , @PathVariable Integer id){
		Map<Object, Object> map = new HashMap<>();
		map.put("data", categoryService.updateCategory(id, categoryDto));
		map.put("success", true);
		return new ResponseEntity<>(map,HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Map<Object, Object>> getCategoryById(@PathVariable Integer id){
		Map<Object, Object> map = new HashMap<>();
		map.put("data", categoryService.getCategoryById(id));
		map.put("success", true);
		return new ResponseEntity<>(map,HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Map<Object, Object>> deleteCategoryById(@PathVariable Integer id){
		Map<Object, Object> map = new HashMap<>();
		map.put("data", "category deleted suceessfully");
		map.put("successs", true);
		return new ResponseEntity<>(map,HttpStatus.OK);
	}
}
