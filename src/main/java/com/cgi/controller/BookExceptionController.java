package com.cgi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.cgi.exceptions.BookNotFoundException;

@ControllerAdvice//methods to be shared acorss multiple @Controller class
public class BookExceptionController {
	@ExceptionHandler(value=BookNotFoundException.class)
	public ResponseEntity<Object> bookGlobalException(BookNotFoundException exception){
		return new ResponseEntity<>(exception.getMessage(),HttpStatus.NOT_FOUND);
	}

}
