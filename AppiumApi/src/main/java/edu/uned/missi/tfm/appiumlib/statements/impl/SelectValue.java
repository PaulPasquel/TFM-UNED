package edu.uned.missi.tfm.appiumlib.statements.impl;

import java.util.HashMap;
import java.util.List;

import edu.uned.missi.tfm.appiumlib.model.Driver;
import edu.uned.missi.tfm.appiumlib.statement.Statement;
import io.appium.java_client.MobileElement;


public class SelectValue extends Statement {

//	private String id;
	
	public SelectValue(HashMap<String, Object> attributes) {
		super(attributes);
	}
	
	@Override
	public String toString() {
		return "select " +  get("value") + " in " + get("id");
	}

	@Override
	public void execute() {		
		logger.info(toString());		
		List <MobileElement> textViews = Driver.getInstance().findElementsByClassName("android.widget.TextView");
		
		for (MobileElement me : textViews) {
			String text = me.getText().toString();
			if(text.compareTo("" + get("value")) == 0) {
				me.click();
				break;
			}
		}
		
//		MobileElement list = this.element.getMElement();
//		this.element.getMElement().sendKeys((String)get("value"));
	}
	
	
}
