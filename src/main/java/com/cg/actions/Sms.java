package com.cg.actions;

import com.cg.actionfactory.utils.BankAppLogger;

public class Sms extends Action {

	private String to;
	private String smsBody;

	public Sms(String to, String smsBody) {
		this.to = to;
		this.smsBody = smsBody;
	}

	@Override
	public void performAction() {
		BankAppLogger logger = new BankAppLogger(getClass());
		logger.info("Sending SMS to \t\t" + to + " : \t" + smsBody);
	}

}
