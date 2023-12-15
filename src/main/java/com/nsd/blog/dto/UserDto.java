package com.nsd.blog.dto;

import jakarta.validation.constraints.Email;
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
public class UserDto {

	private Integer id;

	@NotEmpty
	@Size(min = 4 ,message = "User name min 4 char")
	private String name;

	@Email(message = "emial is not valid")
	private String email;

	@NotEmpty
	@Size(min = 4 ,max = 10 , message = "password between 4 to 10")
	private String password;

	@NotEmpty
	@Size(min = 4 ,max = 100 , message = "about should between 4 to 100")
	private String about;
}
