package com.shawee.hackaton.exceptions;

public class ExistingEmailException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ExistingEmailException(String message) {
		super(message);
	}
	
}
