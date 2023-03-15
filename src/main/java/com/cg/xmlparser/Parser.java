package com.cg.xmlparser;

import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Parser {
	final static String FILENAME = "ExceptionHandler.xml";
	static public Map<String, Map<String, Map<String, Map<String, String>>>> config = new LinkedHashMap<String, Map<String, Map<String, Map<String, String>>>>();

	public static void readXML() {
		DocumentBuilderFactory documentBiBuilderFactory = DocumentBuilderFactory.newInstance();
		try {
			DocumentBuilder docBuilder = documentBiBuilderFactory.newDocumentBuilder();
			Document doc = docBuilder.parse(new File(FILENAME));
			doc.getDocumentElement().normalize();

			NodeList list = doc.getElementsByTagName("module");

			for (int index = 0; index < list.getLength(); index++) {

				Node moduleNode = list.item(index);
				Element moduleElement = (Element) moduleNode;
				String moduleName = moduleElement.getAttribute("name");
				NodeList exceptionList = moduleElement.getElementsByTagName("exception");

				Map<String, Map<String, Map<String, String>>> exceptionMap = new LinkedHashMap<String, Map<String, Map<String, String>>>();
				for (int temp = 0; temp < exceptionList.getLength(); temp++) {

					Node expNode = exceptionList.item(temp);
					Element expElement = (Element) expNode;
					String expName = expElement.getAttribute("name");
					NodeList actionList = expElement.getElementsByTagName("actions");
					Node actionNode = actionList.item(0);
					Element actionElement = (Element) actionNode;
					NodeList allActionNodeList = actionElement.getChildNodes();
					Map<String, Map<String, String>> actionMap = new LinkedHashMap<String, Map<String, String>>();
					for (int i = 0; i < allActionNodeList.getLength(); i++) {
						Node singleActionNode = allActionNodeList.item(i);
						if (singleActionNode.getNodeType() == Node.ELEMENT_NODE) {
							String nodename = singleActionNode.getNodeName();
							Element singleElement = (Element) singleActionNode;
							NamedNodeMap kv = singleElement.getAttributes();
							Map<String, String> attributeMap = new LinkedHashMap<String, String>();
							for (int j = 0; j < kv.getLength(); j++) {
								Node n = kv.item(j);
								attributeMap.put(n.getNodeName(), n.getNodeValue());
							}
							actionMap.put(nodename, attributeMap);
						}
					}
					exceptionMap.put(expName, actionMap);
				}
				config.put(moduleName, exceptionMap);
			}

		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
