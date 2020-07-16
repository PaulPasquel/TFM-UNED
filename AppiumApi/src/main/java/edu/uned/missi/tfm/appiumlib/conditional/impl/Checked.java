package edu.uned.missi.tfm.appiumlib.conditional.impl;

import java.util.HashMap;

import edu.uned.missi.tfm.appiumlib.statement.Conditional;
import io.appium.java_client.MobileElement;

/**
 * Allows to evaluate if a RadioButton/CheckBox was selected
 * @author Paul Pasquel
 *
 */
public class Checked extends Conditional {
	
	public Checked(Boolean denied, HashMap<String, Object> attributes) {
		super(denied, attributes);
	}

	@Override
	public boolean check() {
		logger.info(toString());
		MobileElement e = this.element.getMElement();
		if (e == null) {
			return false;
		}

//		if(e.getAttribute("className").contains("RadioButton")) {
		String value = e.getAttribute("checked");
		if (denied) {
			return !"true".equals(value);
		}
		return "true".equals(value);
	}

	@Override
	public String toString() {
		String condition = (String)get("id") + " is checked";
		if (denied) {
			return "But " + condition;
		}
		return condition;
	}

}
