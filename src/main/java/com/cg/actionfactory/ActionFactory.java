package com.cg.actionfactory;

import com.cg.actions.Action;
import com.cg.actions.Email;
import com.cg.actions.Sms;
import com.cg.actions.Log;

/**
 * Factory class to generate a given Action depending upon the argument passed
 * 
 * @author himanegi
 *
 */
public class ActionFactory {
	/**
	 * Get an action type and return the action
	 * 
	 * @param args[0] = type of action
	 * @param args[1] = attribute list
	 * @return respective action object
	 */
	public Action getAction(String[] args) {
		if (args[0].equals("sms"))
			return new Sms(args[2], args[1]);
		if (args[0].equals("log"))
			return new Log(args[2], args[1]);
		if (args[0].equals("email"))
			return new Email(args[2], args[1]);
		return null;
	}
}
