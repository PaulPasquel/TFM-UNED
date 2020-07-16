package edu.uned.missi.tfm.appiumlib.statement;

import edu.uned.missi.tfm.appiumlib.model.Driver;
import edu.uned.missi.tfm.appiumlib.model.Expression;
import edu.uned.missi.tfm.appiumlib.statement.util.ConditionalFactory;
import edu.uned.missi.tfm.appiumlib.statement.util.ConditionalFactory.CType;
import edu.uned.missi.tfm.appiumlib.statement.util.MapBuilder;
import edu.uned.missi.tfm.appiumlib.statement.util.StatementFactory;
import edu.uned.missi.tfm.appiumlib.statement.util.StatementFactory.SType;

public class Interpreter {

	ConditionalFactory cf = new ConditionalFactory();
	StatementFactory sf = new StatementFactory();
	
	public void startAppiumDriver() {
		Driver.getInstance();
	}
	
	//*
	// Statments
	//*
	public void type(String id, String value) {
		MapBuilder m = new MapBuilder();
		m.add("id", id).add("value",value);
		sf.newStatement(SType.type, m.create()).execute();
	}

	public void pressButton(String id) {
		MapBuilder m = new MapBuilder().add("id", id);
		sf.newStatement(SType.pressButton, m.create()).execute();		
	}

	public void chooseOption(String id) {
		MapBuilder m = new MapBuilder().add("id", id);
		sf.newStatement(SType.chooseOption, m.create()).execute();		
	}
	
	public void selectValue(String id, String value) {
		MapBuilder m = new MapBuilder().add("id", id).add("value", value);
		sf.newStatement(SType.selectValue, m.create()).execute();		
	}
	
	// condition
	public boolean isVisible(Boolean denied, String id) {
		MapBuilder m = new MapBuilder().add("id", id);
		Conditional c = cf.newCondition(CType.visible, denied, m.create());
		return c.check();					
	}

	public boolean isEnabled(Boolean denied, final String id) {
		MapBuilder m = new MapBuilder().add("id", id);
		Conditional c = cf.newCondition(CType.enabled, denied, m.create());
		return c.check();			
	}

	public boolean isChecked(Boolean denied, final String id) {
		MapBuilder m = new MapBuilder().add("id", id);		
		Conditional c = cf.newCondition(CType.check, denied, m.create());
		return c.check();	
	}

	public boolean compare(Boolean denied, String id, Expression expression, String value) {
		MapBuilder m = new MapBuilder();
		m.add("id", id).add("expression", expression).add("value", value);
		Conditional c = cf.newCondition(CType.compare, denied, m.create());
		return c.check();
	}

	public boolean isMessageDisplayed(Boolean denied, String message) {
		MapBuilder m = new MapBuilder().add("message", message);
		m.add("id", "toastArea").add("componentType", "Toast");
		Conditional c = cf.newCondition(CType.messageDisplayed, denied, m.create());
		return c.check();			
	}

	
}
