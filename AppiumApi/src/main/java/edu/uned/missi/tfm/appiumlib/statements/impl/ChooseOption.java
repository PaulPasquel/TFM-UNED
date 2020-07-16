package edu.uned.missi.tfm.appiumlib.statements.impl;

import java.util.HashMap;

import edu.uned.missi.tfm.appiumlib.statement.Statement;


public class ChooseOption extends Statement {

//	private String id;
	
	public ChooseOption(HashMap<String, Object> attributes) {
		super(attributes);
//		attributes.put("componentType", "RadioButton");
	}
	
	@Override
	public String toString() {
		return "choose " + get("id");
	}

	@Override
	public void execute() {		
		logger.info(toString());
		this.element.getMElement().click();
	}
	
	
}
