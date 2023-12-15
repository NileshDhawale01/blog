package com.nsd.blog.exceptions;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.nsd.blog.dto.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<Map<Object, Object>> resourceNotFoundException(ResourceNotFoundException exp){
		
		String msg = exp.getMessage();
		
		ApiResponse apiResponse = new ApiResponse(msg, false);
		Map<Object, Object> map = new HashMap<>();
		map.put("Response", apiResponse);
		return new ResponseEntity<>(map,HttpStatusCode.valueOf(500));
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<Object, Object>> handleMethodArgsNotValidException(MethodArgumentNotValidException exp){
		
		Map<Object, Object> resp = new HashMap<>();
		exp.getBindingResult().getAllErrors().forEach(err->{
			String fieldName = ((FieldError)err).getField();
			String msg = err.getDefaultMessage();
			resp.put(fieldName, msg);
		});
		return new ResponseEntity<>(resp,HttpStatus.BAD_REQUEST);
	}

}
