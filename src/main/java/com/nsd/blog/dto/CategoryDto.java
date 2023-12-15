package com.nsd.blog.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDto {

	private Integer categoryId;
	
	@NotEmpty
	@Size(min = 4 , max = 10 , message = "category title between 4 to 10")
	private String categoryTitle;
	
	@NotEmpty
	@Size(min = 4 , max = 10 , message = "category description can between 4 to 10")
	private String categoryDescription;
}
