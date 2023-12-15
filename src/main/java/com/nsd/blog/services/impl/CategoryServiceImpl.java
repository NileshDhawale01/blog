package com.nsd.blog.services.impl;

import static com.nsd.blog.mappers.CategoryMapper.*;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nsd.blog.dto.CategoryDto;
import com.nsd.blog.entities.Category;
import com.nsd.blog.exceptions.ResourceNotFoundException;
import com.nsd.blog.repositories.CategoryRepo;
import com.nsd.blog.services.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepo categoryRepo;

	@Override
	public CategoryDto saveCategory(CategoryDto categoryDto) {
		Category category = toCategory.apply(categoryDto).get();
		return toCategoryDto.apply(categoryRepo.save(category)).get();
	}

	@Override
	public CategoryDto getCategoryById(Integer id) {
		return toCategoryDto.apply(categoryRepo.findById(id).get())
				.orElseThrow(() -> new ResourceNotFoundException("category", "categoryId", id));
	}

	@Override
	public CategoryDto updateCategory(Integer catId, CategoryDto categoryDto) {
		Category category = categoryRepo.findById(catId)
				.orElseThrow(() -> new ResourceNotFoundException("category", "categoryId", catId));
		category.setCategoryTitle(categoryDto.getCategoryTitle());
		category.setCategoryDescription(categoryDto.getCategoryDescription());
		return toCategoryDto.apply(categoryRepo.save(category)).get();
	}

	@Override
	public void deleteCategoryById(Integer catId) {
		Category category = categoryRepo.findById(catId)
				.orElseThrow(() -> new ResourceNotFoundException("category", "categoryId", catId));
		categoryRepo.delete(category);

	}

	@Override
	public List<CategoryDto> getAllCategorys() {
		return toCategoryDtos.apply(categoryRepo.findAll());
	}

}
