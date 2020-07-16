package edu.uned.missi.tfm.appiumlib.statements.impl;

import java.util.HashMap;

import org.openqa.selenium.interactions.Keyboard;

import edu.uned.missi.tfm.appiumlib.model.Driver;
import edu.uned.missi.tfm.appiumlib.statement.Statement;

public class Type extends Statement {

	public Type(HashMap<String, Object> attributes) {
		super(attributes);
	}

	/*
	 * public Type(String id, String value) { this.id = id; this.value = value;
	 * this.element = new MobileComponent(id,"EditText"); }
	 */
	@Override
	public String toString() {
		return "type " + get("value") + " into " + get("id");
	}

	@Override
	public void execute() {
		logger.info(toString());
		this.element.getMElement().clear();
		this.element.getMElement().sendKeys((String) get("value"));
		try {
			Driver.getInstance().hideKeyboard();
		}catch (Exception e) {
			// keyboard is not presented
		}
	}

}
