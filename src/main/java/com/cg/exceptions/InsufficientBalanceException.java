package com.cg.exceptions;

@SuppressWarnings("serial")
public class InsufficientBalanceException extends Exception{
	public InsufficientBalanceException() {
		super();
	}

	@Override
	public String toString() {
		return "InsufficientBalanceException";
	}
	
}
