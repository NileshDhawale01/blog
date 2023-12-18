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
public class CommentDto {

	private Integer id;
	
	@NotEmpty
	@Size(max = 100 , min = 5 , message = "content between 5 to 100")
	private String content;

	@NotEmpty
	private PostDto postDto;
	
	@NotEmpty
	private UserDto userDto;
}
