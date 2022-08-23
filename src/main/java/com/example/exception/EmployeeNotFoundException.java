package com.example.exception;

public class EmployeeNotFoundException extends RuntimeException{

	public EmployeeNotFoundException(String str) {
		super(str);
	}
}
