package edu.uned.missi.tfm.appiumlib.model;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class MobileComponent {

	private static Logger logger = LogManager.getLogger("APPIUM");

	private String id;
	private String componentType;
	private MobileElement me;

	private AndroidDriver<MobileElement> ad;

	public MobileComponent(String id, String componentType) {
		logger.debug("Instancing element [" + id + "]");
		this.ad = Driver.getInstance();
		this.id = id;
		this.componentType = componentType;
		this.me = find();
//		
		if (this.me == null && componentType != null && componentType.equals("RadioButton")) {
			this.componentType = "CheckBox";
			this.me = find();
		}
	}

	public String getId() {
		return this.id;
	}

	private MobileElement find() {
// Toast				
		if ("Toast".equals(componentType)) {
			return ad.findElement(By.xpath("/hierarchy/android.widget.Toast"));
		}

		String using = id.replace('.', ' ');
		List<MobileElement> list = ad.findElementsByAccessibilityId(using);
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		if (componentType == null) {
			list = ad.findElements(By.xpath("//*[ends-with(@resource-id, '" + using + "')]"));
			if (list != null && list.size() > 0) {
				return list.get(0);
			}
//			logger.warn("Element [" + id + "] or [" + using + "] is not found ");
		}
		//
//		String xPath = "android.widget." + componentType + "[@content-desc=\"";
//		xPath = xPath + using + "\"]";
//		MobileElement temp = ad.findElementByXPath(xPath);
//		if (temp == null) {
			list = ad.findElements(By.xpath("//*[ends-with(@resource-id, '" + using + "')]"));
			if (list != null && list.size() > 0) {
				return list.get(0);
			}
			logger.warn("Element [" + id + "] or [" + using + "] is not found ");
//		}
		return null;

	}

	// //android.widget.EditText[@content-desc="Plazo Hipoteca"]
	// //android.widget.CheckBox[@content-desc="Calcular Por Importe"]
	// //android.widget.RadioButton[@content-desc="Años"]
	// //android.widget.Button[@content-desc="Calcular"]

	public MobileElement getMElement() {
		return me;
	}
}
