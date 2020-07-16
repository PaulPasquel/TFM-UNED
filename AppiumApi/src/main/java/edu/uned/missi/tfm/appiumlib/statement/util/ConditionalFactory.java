package edu.uned.missi.tfm.appiumlib.statement.util;

import java.util.HashMap;

import edu.uned.missi.tfm.appiumlib.conditional.impl.Checked;
import edu.uned.missi.tfm.appiumlib.conditional.impl.Compare;
import edu.uned.missi.tfm.appiumlib.conditional.impl.Enabled;
import edu.uned.missi.tfm.appiumlib.conditional.impl.MessageDisplayed;
import edu.uned.missi.tfm.appiumlib.conditional.impl.Visible;
import edu.uned.missi.tfm.appiumlib.statement.Conditional;

public class ConditionalFactory {

	public enum CType {
		check, compare, enabled, messageDisplayed, visible
	}

	public Conditional newCondition(CType type, Boolean denied, HashMap<String, Object> attributes) {
		switch (type) {
		case check:
			return new Checked(denied, attributes);
		case compare:
			return new Compare(denied, attributes);
		case enabled:
			return new Enabled(denied, attributes);
		case messageDisplayed:
			return new MessageDisplayed(denied, attributes);
		case visible:
			return new Visible(denied, attributes);
		}
		return null;
	}

}
