package edu.uned.missi.tfm.appiumlib.conditional.impl;

import java.util.HashMap;

import edu.uned.missi.tfm.appiumlib.statement.Conditional;
import io.appium.java_client.MobileElement;

public class Enabled extends Conditional {
		
//	private String id;
//	private boolean denied = false;
	
	public Enabled(Boolean denied, HashMap<String, Object> attributes) {
		super(denied, attributes);
	}
	
	@Override
	public boolean check() {
		logger.info(toString());
		MobileElement e = this.element.getMElement();
		if(e == null) {
			return false;
		}
		
		if(denied) {
			return !e.isEnabled();
		}
		return e.isEnabled();
	}
	
	@Override
	public String toString() {
		String condition = get("id") + " is enabled";
		if(denied) {
			return "But " + condition; 
		}
		return  condition;
	}

}
