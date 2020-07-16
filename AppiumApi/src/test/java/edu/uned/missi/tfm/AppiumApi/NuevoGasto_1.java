package edu.uned.missi.tfm.AppiumApi;

/*
 No: 1
 Description:
 El usuario ingresa el importe del pr�stamo, la tasa, y plazo.
 	El plazo de la hipoteca est� indicado en meses
 Thu Jul 09 10:42:52 COT 2020
*/ 

import edu.uned.missi.tfm.appiumlib.model.Expression;
import edu.uned.missi.tfm.test.impl.Scenario;

public class NuevoGasto_1 extends Scenario{
								
	//
	//Given
	//
	public void given(){
		isVisible("bAddw");
		
	}
				
	//
	// When
	//
	public void when(){	
		pressButton("bAddw");
		type("etWKwota","100.12");
		type("etWOpis","Queso");
		pressButton("ok");
		
	}
				
	//
	// Then
	//
	public void then(){	
		compare("text1wyd",Expression.contains,"Queso");
		
	}
				
} 
