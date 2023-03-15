package com.cg.actions;

public class Sms extends Action {

	private String to;
	private String smsBody;

	public Sms(String to, String smsBody) {
		this.to = to;
		this.smsBody = smsBody;
	}

	@Override
	public void performAction() {
		System.out.println("Sending SMS to " + to + " : " + smsBody);
	}

}
