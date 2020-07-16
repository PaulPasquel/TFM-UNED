package edu.uned.missi.tfm.appiumlib.statement;

import java.util.HashMap;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import edu.uned.missi.tfm.appiumlib.model.MobileComponent;

/**
 * Conditional, represent a condition evaluation statement
 * @author Paul Pasquel
 *
 */
public abstract class Conditional {

	protected static Logger logger = LogManager.getLogger("APPIUM");

	// object atrtributes (id, value, message)
	protected HashMap<String, Object> attributes;
	
	// Represent the use of BUT
	protected boolean denied = false;
	
	// visible element
	protected MobileComponent element;
	
	public MobileComponent getElement() {
		return element;
	}
	
	// evaluation method to implement at each condition instance
	public abstract boolean check();
	
	// Constructor
	public Conditional(Boolean denied, HashMap<String, Object> attributes) {
		this.denied = denied;
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
	
	protected boolean isAttribtuePresent(String attribute) {
	    Boolean result = false;
	    try {
	        String value = element.getMElement().getAttribute(attribute);
	        if (value != null){
	            result = true;
	        }
	    } catch (Exception e) {}

	    return result;
	}	
}
