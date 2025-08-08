package com.webapp.exception;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class UserException {
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> handleException(MethodArgumentNotValidException ex, HttpServletRequest request){
		List<FieldError> errors = ex.getFieldErrors();
		
		List<String> data = errors.stream().map(e->e.getField()+" "+e.getDefaultMessage()).toList();
		
		return ResponseEntity.badRequest().body(data);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> exception(Exception ex, HttpServletRequest request){
		String message  = ex.getMessage();
		return ResponseEntity.badRequest().body(message);
	}
	
	@ExceptionHandler(NullPointerException.class)
	public ResponseEntity<String> exceptionData(NullPointerException ex, HttpServletRequest rx){
		return ResponseEntity.badRequest().body("method from ControllerAdvice :"+ex.getLocalizedMessage());
	}

}
