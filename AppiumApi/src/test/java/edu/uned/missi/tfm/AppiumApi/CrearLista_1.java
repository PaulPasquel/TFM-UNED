package edu.uned.missi.tfm.AppiumApi;

/*
 No: 1
 Description:
 El usuario presiona el botón Agregar, e ingresa el nombre de la lista
 Thu Jul 09 23:34:26 COT 2020
*/ 

import edu.uned.missi.tfm.appiumlib.model.Expression;
import edu.uned.missi.tfm.test.impl.Scenario;

public class CrearLista_1 extends Scenario{
								
	//
	//Given
	//
	public void given(){
		isVisible("Agregar.Lista");
		
	}
				
	//
	// When
	//
	public void when(){	
		pressButton("Agregar.Lista");
		type("Nombre.Lista","Víveres");
		pressButton("Aceptar");
		
	}
				
	//
	// Then
	//
	public void then(){	
		isMessageDisplayed("Lista Víveres agregada!");
		
	}
				
} 
