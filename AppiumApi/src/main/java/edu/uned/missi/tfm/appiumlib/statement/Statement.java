package edu.uned.missi.tfm.appiumlib.statement;

import java.util.HashMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import edu.uned.missi.tfm.appiumlib.model.MobileComponent;

public abstract class Statement {
	
	protected static Logger logger = LogManager.getLogger("APPIUM");

	// object atrtributes (id, value, message)
	protected HashMap<String, Object> attributes;
	
	protected MobileComponent element;
	
	public MobileComponent getElement() {
		return element;
	}
	
	public abstract void execute();

	// Constructor
	public Statement(HashMap<String, Object> attributes) {
		this.attributes = attributes;
		if(exists("id") == false) {
			throw new RuntimeException("Conditional object requires an id attribute");
		}
		String id = (String)attributes.get("id");
		String componentType = (String)attributes.get("componentType");
		this.element = new MobileComponent(id,componentType);		
	}
	
	// 
	public Object get(String attribute) {
		return attributes.get(attribute);
	}
	
	public Boolean exists(String attribute) {
		if(attribute == null) {
			return false;
		}
		return attributes.containsKey(attribute);
	}
	
}
