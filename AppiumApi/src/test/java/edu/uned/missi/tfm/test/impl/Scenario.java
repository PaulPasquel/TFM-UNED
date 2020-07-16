package edu.uned.missi.tfm.test.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import edu.uned.missi.tfm.appiumlib.model.Expression;
import edu.uned.missi.tfm.appiumlib.statement.Interpreter;

public abstract class Scenario {

	private static Logger logger = LogManager.getLogger("APPIUM");

	private Interpreter interpreter = new Interpreter();

	public abstract void given();

	public abstract void when();

	public abstract void then();

	@Before
	public void config() {
	   interpreter.startAppiumDriver();	
	}

//

	public void type(String id, String value) {
		interpreter.type(id, value);
	}

	public void pressButton(String id) {
		interpreter.pressButton(id);
	}

	public void chooseOption(String id) {
		interpreter.chooseOption(id);
	}

	public void selectValue(String id, String value) {
		interpreter.selectValue(id,value);
	}
	
// condition

	public void isVisible(String id) {
		Assert.assertTrue(interpreter.isVisible(false, id));
	}

	public void isNotVisible(String id) {
		Assert.assertTrue(interpreter.isVisible(true, id));
	}

	public void isEnabled(String id) {
		Assert.assertTrue(interpreter.isEnabled(false, id));
	}

	public void isNotEnabled(String id) {
		Assert.assertTrue(interpreter.isEnabled(true, id));
	}

	public void isChecked(String id) {
		Assert.assertTrue(interpreter.isChecked(false, id));
	}

	public void isNotChecked(String id) {
		Assert.assertTrue(interpreter.isChecked(true, id));
	}

	public void compare(String id, Expression expression, String value) {
		Assert.assertTrue(interpreter.compare(false, id, expression, value));
	}

	public void notCompare(String id, Expression expression, String value) {
		Assert.assertTrue(interpreter.compare(true, id, expression, value));
	}

	public void isMessageDisplayed(String message) {
		Assert.assertTrue(interpreter.isMessageDisplayed(false, message));
	}

	@Test
	public void run() {
		logger.info("----------------");
		logger.info("Given:");
		logger.info("----------------");
		given();
		logger.info("----------------");
		logger.info("When:");
		logger.info("----------------");
		when();
		logger.info("----------------");
		logger.info("Then:");
		logger.info("----------------");
		then();
		logger.info("----------------");
		logger.info("PASSED");
		logger.info("----------------");
	}
}
