package com.nsd.blog.exceptions;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ResourceNotFoundException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String resourceName;
	
	private String fieldName;
	
	private Integer value;
	
	public ResourceNotFoundException(String resourceName , String fieldName , Integer value) {
		
		super(String.format("%s not found with %s : %s",resourceName , fieldName,value));
		this.resourceName =resourceName;
		
		this.fieldName = fieldName;
		
		this.value = value;
	}	
	
}
