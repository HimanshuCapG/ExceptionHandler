package com.cg.exceptions;

@SuppressWarnings("serial")
public class AccountNotFoundException extends Exception {
	public AccountNotFoundException() {
		super();
	}

	@Override
	public String toString() {
		return "AccountNotFoundException";
	}
	
}
