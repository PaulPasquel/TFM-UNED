package edu.uned.missi.tfm.appiumlib.conditional.impl;

import java.util.HashMap;

import edu.uned.missi.tfm.appiumlib.model.Expression;
import edu.uned.missi.tfm.appiumlib.statement.Conditional;
import io.appium.java_client.MobileElement;

public class Compare extends Conditional {

	private Expression expression;

	public Compare(Boolean denied, HashMap<String, Object> attributes) {
		super(denied, attributes);
		expression = (Expression) attributes.get("expression");
	}

	@Override
	public String toString() {
		String id = (String) get("id");
		String value = (String) get("value");
		if (value == null || "".equals(value.trim())) {
			value = "[vacío]";
		}
		String condition = "compare " + id + " " + expression + " " + value;
		if (denied) {
			return "But " + condition;
		}
		return condition;
	}

	@Override
	public boolean check() {
		logger.info(toString());
		MobileElement e = this.element.getMElement();
		if (e == null) {
			return false;
		}
		String value = (String) get("value"); // Expression Value
		String eleValue = e.getText(); // Component Content
//
// When empty, textField has name equals to value
		if (isAttribtuePresent("content-desc")) {
			String name = e.getAttribute("content-desc");
			if (name.equals(eleValue)) {
				eleValue = "";
			}
		}
//		

		if (denied) {
			return !expression.evaluate(eleValue, value);
		}
		return expression.evaluate(eleValue, value);
	}

}
