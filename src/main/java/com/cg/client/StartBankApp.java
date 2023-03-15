package com.cg.client;

import com.cg.actionhandler.ActionHandler;
import com.cg.exceptions.AccountNotFoundException;
import com.cg.exceptions.InsufficientBalanceException;
import com.cg.xmlparser.Parser;

public class StartBankApp {
	static ActionHandler handler = new ActionHandler();

	public static void WithdrawAmount() {
		handler.handle(new AccountNotFoundException());
	}

	public static void DepositAmount() {
		handler.handle(new AccountNotFoundException());
	}

	public static void FundTransfer() {
		handler.handle(new InsufficientBalanceException());
	}

	public static void start() {
		Parser.readXML(); // must be callable once
		WithdrawAmount();
//		DepositAmount();
//		FundTransfer();
	}
}
