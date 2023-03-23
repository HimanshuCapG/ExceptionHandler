package com.cg.actions;

import com.cg.actionfactory.utils.BankAppLogger;

public class Log extends Action {
	private String name;
	private String file;

	public Log(String name, String file){
		this.name = name;
		this.file = file;
	}

	@Override
	public void performAction() {
		BankAppLogger logger = new BankAppLogger(getClass());
		logger.info("Writing logs to \t" + name + " : \t" + file);
	}

}
