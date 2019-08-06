package com.example.demo.exception;

public class EmployeeDoesNotExistException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public EmployeeDoesNotExistException(String message)
	{
		super(message);
	}

}