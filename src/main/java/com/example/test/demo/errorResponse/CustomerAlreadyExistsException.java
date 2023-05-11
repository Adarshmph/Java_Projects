package com.example.test.demo.errorResponse;

public class CustomerAlreadyExistsException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	public CustomerAlreadyExistsException(String msg){
		super(msg);
	}
} 
