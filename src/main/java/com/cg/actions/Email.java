package com.cg.actions;

import com.cg.actionfactory.utils.BankAppLogger;

public class Email extends Action {
	private String to;
	private String emailBody;

	public Email(String to, String emailBody) {
		this.to = to;
		this.emailBody = emailBody;
	}

	@Override
	public void performAction() {
		BankAppLogger logger = new BankAppLogger(getClass());
		logger.info("Sending mail to \t" + to + " : \t" + emailBody);
	}

}
