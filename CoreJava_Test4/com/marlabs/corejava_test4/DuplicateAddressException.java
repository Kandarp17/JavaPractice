package com.marlabs.corejava_test4;

@SuppressWarnings("serial")
public class DuplicateAddressException extends RuntimeException {
	String message;

	public DuplicateAddressException() {
		super();
	}
	
	public DuplicateAddressException(String message) {
		super(message);
	}
	
}
