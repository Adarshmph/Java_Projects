package com.example.test.demo.errorResponse;

public class MethodArgumentNotValidException extends Exception {

	private static final long serialVersionUID = 1L;

	public MethodArgumentNotValidException(String msg) {
		super(msg);
	}

}
