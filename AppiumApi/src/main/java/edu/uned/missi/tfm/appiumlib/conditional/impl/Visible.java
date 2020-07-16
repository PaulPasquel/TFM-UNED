package edu.uned.missi.tfm.appiumlib.conditional.impl;

import java.util.HashMap;

import edu.uned.missi.tfm.appiumlib.statement.Conditional;
import io.appium.java_client.MobileElement;

public class Visible extends Conditional {
	
//	private String id;
//	private boolean denied = false;
	
	public Visible(Boolean denied, HashMap<String, Object> attributes) {
		super(denied, attributes);
	}
	/*
	public Visible(Boolean denied, String id) {
		this.id = id;
		this.denied = denied;
		this.element = new MobileComponent(id,null);
	}
*/
	@Override
	public boolean check() {
		logger.info(toString());
		MobileElement e = this.element.getMElement();
		if(e == null) {
			return false;
		}
		
		if(denied) {
			return !e.isDisplayed();
		}
		return e.isDisplayed();
	}
	
	@Override
	public String toString() {
		String condition = get("id") + " is visible";
		if(denied) {
			return "But " + condition; 
		}
		return  condition;
	}

}
