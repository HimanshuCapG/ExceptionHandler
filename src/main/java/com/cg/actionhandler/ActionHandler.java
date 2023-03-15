package com.cg.actionhandler;

import java.util.Map;

import com.cg.xmlparser.Parser;
import com.cg.actionfactory.ActionFactory;
import com.cg.actions.Action;

/**
 * Action handler class to be called when an exception occurs. This class
 * handles the exceptions based upon the type of action and the class from where
 * it was thrown and generated respective action
 * 
 * @author himanegi
 *
 */
public class ActionHandler {

	// Factory object to get action object
	static ActionFactory factory = new ActionFactory();

	/**
	 * Function to handle provided exception. Gets the function name and exception
	 * name and perform respective actions.
	 * 
	 * @param exception
	 */
	public void handle(Exception exception) {
		StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();

		String methodName = stackTraceElements[2].getMethodName();
		String exceptionName = exception.toString();

		Map<String, Map<String, String>> actionMap = Parser.config.get(methodName).get(exceptionName);

		actionMap.forEach((key, attributes) -> {
			String attribute1 = (String) attributes.values().toArray()[0];
			String attribute2 = (String) attributes.values().toArray()[1];
			String[] args = { key, attribute1, attribute2 };
			Action action = factory.getAction(args);
			action.performAction();
		});

	}
}
