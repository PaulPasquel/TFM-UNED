package edu.uned.missi.tfm.appiumlib.conditional.impl;

import java.util.HashMap;

import edu.uned.missi.tfm.appiumlib.statement.Conditional;
import io.appium.java_client.MobileElement;

public class MessageDisplayed extends Conditional {

//	private String message;
//	private boolean denied = false;

	public MessageDisplayed(Boolean denied, HashMap<String, Object> attributes) {
		super(denied, attributes);
	}

	/*
	 * public MessageDisplayed(Boolean denied, String message) { this.message =
	 * message; this.denied = denied; this.element = new
	 * MobileComponent("toastArea", "Toast"); }
	 */
	@Override
	public boolean check() {
		logger.info(toString());
		MobileElement e = this.element.getMElement();
		if (e == null) {
			return false;
		}

		String value = e.getAttribute("name");
		String message = (String) get("message");
		if (denied) {
			return !value.contains(message);
		}
		return value.contains(message);
	}

	@Override
	public String toString() {
		String condition = "Message " + get("message") + " is showed";
		if (denied) {
			return "But " + condition;
		}
		return condition;
	}

}
