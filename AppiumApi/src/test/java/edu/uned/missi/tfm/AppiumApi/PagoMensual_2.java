package edu.uned.missi.tfm.AppiumApi;

/*
 No: 2
 Description:
 El usuario ingresar los datos requeridos, excepto la Tasas de Interés,
      El sistema debe indicar que la Tasa de Interés de obligatorio
 Sun Jun 07 12:53:17 COT 2020
*/

import edu.uned.missi.tfm.appiumlib.model.Expression;
import edu.uned.missi.tfm.test.impl.Scenario;

public class PagoMensual_2 extends Scenario {

	//
	// Given
	//
	public void given() {
		isChecked("Calcular Por Importe");
		isNotChecked("Calcular Por Cuota");
		compare("Tasa.De.Interés", Expression.equals, "");

	}

	//
	// When
	//
	public void when() {
		type("Importe.Del.Préstamo", "1000");
		type("Plazo.Hipoteca", "240");
		chooseOption("Meses");
		pressButton("Calcular");

	}

	//
	// Then
	//
	public void then() {
		isMessageDisplayed("Tasa De Interés es obligatorio.");

	}
}
