package com.cg.exceptions;

@SuppressWarnings("serial")
public class AccountNotFoundException extends Exception {
	public AccountNotFoundException(String e) {
		super(e);
	}

	@Override
	public String toString() {
		return "AccountNotFoundException";
	}
	
}
