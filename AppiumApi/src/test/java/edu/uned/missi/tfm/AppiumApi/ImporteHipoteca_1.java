package edu.uned.missi.tfm.AppiumApi;

/*
 No: 1
 Description:
 El usuario ingresa el importe del préstamo, la tasa, y plazo.
 	El plazo de la hipoteca está indicado en meses
 Sat Jun 06 19:08:06 COT 2020
*/

import edu.uned.missi.tfm.appiumlib.model.Expression;
import edu.uned.missi.tfm.test.impl.Scenario;

public class ImporteHipoteca_1 extends Scenario {

	//
	// Given
	//
	public void given() {
		isChecked("Calcular Por Importe");
		isEnabled("Importe.Del.Préstamo");
		isNotChecked("Calcular Por Cuota");

	}

	//
	// When
	//
	public void when() {
		type("Importe.Del.Préstamo", "1000");
		type("Tasa.De.Interés", "12");
		type("Plazo.Hipoteca", "240");
		chooseOption("Meses");
		pressButton("Calcular");

	}

	//
	// Then
	//
	public void then() {
		compare("Cuota.Mensual", Expression.equals, "11.01");

	}
}
