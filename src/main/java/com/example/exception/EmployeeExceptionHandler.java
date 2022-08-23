package com.example.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;



@RestControllerAdvice
public class EmployeeExceptionHandler {
	@ExceptionHandler(EmployeeNotFoundException.class)
	public ResponseEntity<ErrorMassage> getExceptionData(EmployeeNotFoundException exception){
		ErrorMassage error=new ErrorMassage(506,exception.getMessage());
		return new ResponseEntity<ErrorMassage>(error,HttpStatus.NOT_FOUND);
		
	}

}
