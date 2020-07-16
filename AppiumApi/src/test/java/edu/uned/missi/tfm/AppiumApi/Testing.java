package edu.uned.missi.tfm.AppiumApi;

import static org.junit.Assert.assertTrue;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class Testing {
	
	AndroidDriver<MobileElement> driver;
	
	@Before
	public void setup() throws MalformedURLException {
		HashMap<String, String> properties = new HashMap<>();
		properties.put("deviceName", "emulator-5554");
		properties.put("platformName", "android");
		properties.put("appPackage", "edu.uned.missi.calcprestamo");
		properties.put("appActivity", "edu.uned.missi.calcprestamo.MainActivity");
		properties.put("noReset", "true");

		// 2
		final String URL_STRING = "http://127.0.0.1:4723/wd/hub";
		URL url = new URL(URL_STRING);
		// 3
		DesiredCapabilities capabilities = new DesiredCapabilities(properties);
		driver = new AndroidDriver<MobileElement>(url, capabilities);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}
	
	void execute() {
		MobileElement el1 = (MobileElement) driver.findElementById("edu.uned.missi.calcprestamo:id/chkLoanAmount");		
		el1.click();
		MobileElement el2 = (MobileElement) driver.findElementById("edu.uned.missi.calcprestamo:id/txtLoanAmount");
		el2.sendKeys("100000");
		MobileElement el3 = (MobileElement) driver.findElementById("edu.uned.missi.calcprestamo:id/txtInterestRate");
		el3.sendKeys("12");
		MobileElement el4 = (MobileElement) driver.findElementById("edu.uned.missi.calcprestamo:id/txtNoOfPayments");
		el4.sendKeys("240");
//		MobileElement el5 = (MobileElement) driver.findElementById("edu.uned.missi.calcprestamo:id/rbtnMonths");
		//el5.click();
		MobileElement el6 = (MobileElement) driver.findElementById("edu.uned.missi.calcprestamo:id/btnCalculate");
		el6.click();
		//
		MobileElement el7 = (MobileElement) driver.findElementById("edu.uned.missi.calcprestamo:id/txtPaymentAmount");
		String value = el7.getText();
		//assertEquals(arg0, arg1, arg2);ssertEquals(value, );
		assertTrue("ok", "1101.09".equals(value));
	}
	
	@Test
	public void run() {
		execute();
	}

}
