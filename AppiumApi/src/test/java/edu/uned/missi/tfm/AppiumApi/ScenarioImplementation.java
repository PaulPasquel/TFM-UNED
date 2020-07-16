package edu.uned.missi.tfm.AppiumApi;

import edu.uned.missi.tfm.appiumlib.model.Expression;
import edu.uned.missi.tfm.test.impl.Scenario;

public class ScenarioImplementation extends Scenario {

	@Override
	public void given() {
		isChecked("Calcular.Por.Importe");		
	}

	@Override
	public void when() {
		this.config();
		chooseOption("Calcular.Por.Importe");
		type("Importe.Del.Préstamo", "10000");
		type("Tasa.De.Interés","12");
		type("Plazo.Hipoteca","240");
		chooseOption("Meses");
		pressButton("Calcular");		
	}

	@Override
	public void then() {
		compare("Cuota.Mensual", Expression.greaterEqualsThan, "110.11");
		compare("Cuota.Mensual", Expression.lessEqualsThan, "110.11");
	}

	
}
