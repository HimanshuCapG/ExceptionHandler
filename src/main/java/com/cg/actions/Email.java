package com.cg.actions;

public class Email extends Action {
	private String to;
	private String emailBody;

	public Email(String to, String emailBody) {
		this.to = to;
		this.emailBody = emailBody;
	}

	@Override
	public void performAction() {
		System.out.println("Sending mail to \t" + to + " : \t" + emailBody);
	}

}
