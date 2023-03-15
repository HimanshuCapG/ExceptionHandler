package com.cg.exceptions;

@SuppressWarnings("serial")
public class NegativeAmountException extends Exception {
	public NegativeAmountException() {
		super();
	}

	@Override
	public String toString() {
		return "NegativeAmountException";
	}
}
