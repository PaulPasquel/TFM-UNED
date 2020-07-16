package edu.uned.missi.tfm.appiumlib.model;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Driver {

	private static final Logger logger = LogManager.getLogger("APPIUM");
	
	private static Driver instance;
	private AndroidDriver<MobileElement> driver;
	private static int wait = 5;
	
	private Driver() throws IOException {
// load properties from file		
		Properties properties = new Properties();
		properties.load(Driver.class.getClassLoader().getResourceAsStream("aatDSL.properties"));
// Instance capabilities		
		URL url = null;
		HashMap<String,String> prop = new HashMap<String, String>();  
		for (final String name: properties.stringPropertyNames()) {
			logger.debug("[" + name + "] = " +  properties.getProperty(name));
			if(name == "waitForElement") {
				continue;
			}
			if("url".equals(name)) {
				url = new URL(properties.getProperty(name));
			} else {
				prop.put(name, properties.getProperty(name));
			}
		}
		
		Object waitForElement = properties.get("waitForElement");
		if(waitForElement != null) {
			wait = Integer.parseInt("" + waitForElement);
		}
		
		DesiredCapabilities capabilities = new DesiredCapabilities(prop);
// start Android Driver
		driver = new AndroidDriver<MobileElement>(url, capabilities);
	}
	
	public static AndroidDriver<MobileElement> getInstance() { 
		if(instance == null) {
			try {
				instance = new Driver();
				instance.driver.manage().timeouts().implicitlyWait(wait, TimeUnit.SECONDS);
			} catch (IOException e) {
				logger.error(e,e);
			}
		}

		return instance.driver;
	}
		
}
