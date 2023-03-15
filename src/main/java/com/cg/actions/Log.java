package com.cg.actions;

public class Log extends Action {
	private String name;
	private String file;

	public Log(String name, String file){
		this.name = name;
		this.file = file;
	}

	@Override
	public void performAction() {
		System.out.println("Writing logs to \t" + name + " : \t" + file);
	}

}
