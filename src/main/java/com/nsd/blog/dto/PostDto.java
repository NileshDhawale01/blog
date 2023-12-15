package com.nsd.blog.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostDto {

	private Integer postId;

	private String title;

	private String content;

	private String imageName = "image.png";

	private CategoryDto categoryDto;
	
	private Date addedDate;

	private UserDto userDto;
}
