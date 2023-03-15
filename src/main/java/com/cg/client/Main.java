package com.cg.client;

import com.cg.actionhandler.ActionHandler;
import com.cg.exceptions.AccountNotFoundException;
import com.cg.exceptions.InsufficientBalanceException;
import com.cg.xmlparser.Parser;

/**
 * Class to test the action handler. Sample class that resembles the client code
 * that might generate errors.
 * 
 * @author himanegi
 *
 */
public class Main {
	static ActionHandler handler = new ActionHandler();

	public static void WithdrawAmount() {
		handler.handle(new AccountNotFoundException("Some Err"));
	}

	public static void DepositAmount() {
		handler.handle(new AccountNotFoundException("Some Err"));
	}

	public static void FundTransfer() {
		handler.handle(new InsufficientBalanceException());
	}

	public static void main(String[] args) {
		Parser.readXML(); // must be callable once

//		WithdrawAmount();
//		FundTransger();
		DepositAmount();
	}
}
