package edu.uned.missi.tfm.appiumlib.statements.impl;

import java.util.HashMap;

import edu.uned.missi.tfm.appiumlib.statement.Statement;


public class PressButton extends Statement {

	public PressButton(HashMap<String, Object> attributes) {
		super(attributes);
	}
	
	@Override
	public String toString() {
		return "press over " + get("id");
	}

	@Override
	public void execute() {	
		logger.info(toString());		
		this.element.getMElement().click();
	}
	
}
