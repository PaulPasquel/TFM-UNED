package edu.uned.missi.tfm.appiumlib.statement.util;

import java.util.HashMap;

import edu.uned.missi.tfm.appiumlib.statement.Statement;
import edu.uned.missi.tfm.appiumlib.statements.impl.ChooseOption;
import edu.uned.missi.tfm.appiumlib.statements.impl.PressButton;
import edu.uned.missi.tfm.appiumlib.statements.impl.SelectValue;
import edu.uned.missi.tfm.appiumlib.statements.impl.Type;

public class StatementFactory {

	public enum SType {
		chooseOption, pressButton, type, selectValue
	}

	public Statement newStatement(SType type, HashMap<String, Object> attributes) {

		switch (type) {
		case chooseOption:
			attributes.put("componentType", "RadioButton");
			return new ChooseOption(attributes);
		case pressButton:
			return new PressButton(attributes);
		case type:
			attributes.put("componentType", "EditText");
			return new Type(attributes);
		case selectValue:
			attributes.put("componentType", "ListView");
			return new SelectValue(attributes);
		default:
			break;
		}

		return null;
	}

}
