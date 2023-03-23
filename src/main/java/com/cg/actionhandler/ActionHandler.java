package com.cg.actionhandler;

import java.lang.reflect.Method;
import java.util.Map;

import com.cg.xmlparser.Parser;
import com.cg.actionfactory.ActionFactory;

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

	static {
		Parser.readXML();
	}

	/**
	 * Function to handle provided exception. Gets the function name and exception
	 * name and perform respective actions.
	 * 
	 * @param exception
	 */
	public static void handle(Exception exception) {
		StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();

		String methodName = stackTraceElements[2].getMethodName();
		String exceptionName = exception.toString();

		System.out.println("\n" + exception.getMessage() + "\n");

//		System.out.println(methodName + " threw " + exceptionName + "\n");

		Map<String, Map<String, String>> actionMap = null;
		try {
			actionMap = Parser.config.get(methodName).get(exceptionName);
		} catch (Exception e) {
			System.err.println("Could not load action from XML");
			return;
		}
		actionMap.forEach((key, attributes) -> {
			String attribute1 = (String) attributes.values().toArray()[0];
			String attribute2 = (String) attributes.values().toArray()[1];
			String[] args = { key, attribute1, attribute2 };
			try {
				Class<?> actionClass = Class.forName("com.cg.actions.Action");
				Object action = factory.getAction(args);
				Method method = actionClass.getMethod("performAction");
				method.invoke(action);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}
}
