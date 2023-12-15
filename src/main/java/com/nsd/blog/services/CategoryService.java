package com.nsd.blog.services;

import java.util.List;

import com.nsd.blog.dto.CategoryDto;

public interface CategoryService {

	CategoryDto saveCategory(CategoryDto categoryDto);
	
	CategoryDto getCategoryById(Integer id);
	
	CategoryDto updateCategory(Integer catId , CategoryDto categoryDto);
	
	void deleteCategoryById(Integer catId);
	
	List<CategoryDto> getAllCategorys();
}
