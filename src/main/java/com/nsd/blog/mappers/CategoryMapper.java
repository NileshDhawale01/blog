package com.nsd.blog.mappers;

import static com.nsd.blog.utils.CollectionUtil.newList;
import static com.nsd.blog.utils.FunctionUtil.evalMapper;
import static com.nsd.blog.utils.FunctionUtil.evalMapperCollection;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import com.nsd.blog.dto.CategoryDto;
import com.nsd.blog.entities.Category;

public class CategoryMapper {

	private CategoryMapper() {}
	
	public static final Function<Category, Optional<CategoryDto>> toCategoryDto =e->evalMapper(e, CategoryDto.class);
	
	public static final Function<CategoryDto, Optional<Category>> toCategory = e->evalMapper(e, Category.class);
	
	public static final Function<Collection<Category>, List<CategoryDto>> toCategoryDtos = e->newList(evalMapperCollection(e, CategoryDto.class));
	
	public static final Function<Collection<CategoryDto>, List<Category>> toCategorys = e->newList(evalMapperCollection(e, Category.class));
}
