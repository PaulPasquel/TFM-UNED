/*
 * generated by Xtext 2.21.0
 */
package edu.uned.iss.tfm.generator

import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.AbstractGenerator
import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.xtext.generator.IGeneratorContext
import edu.uned.iss.tfm.aatDSL.Scenario
import edu.uned.iss.tfm.aatDSL.OptionIsChecked
import edu.uned.iss.tfm.aatDSL.IsEnabled
import edu.uned.iss.tfm.aatDSL.ValueIsSelected
import edu.uned.iss.tfm.aatDSL.MessageIsDisplayed
import edu.uned.iss.tfm.aatDSL.TextContains
import edu.uned.iss.tfm.aatDSL.InputText
import edu.uned.iss.tfm.aatDSL.ButtonPress
import edu.uned.iss.tfm.aatDSL.OptionChoose
import edu.uned.iss.tfm.aatDSL.ValueSelect
import java.util.Date
import edu.uned.iss.tfm.aatDSL.IsVisible

/**
 * Generates code from your model files on save.
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#code-generation
 */
class AatDSLGenerator extends AbstractGenerator {

	final String PKG = "edu.uned.missi.tfm.AppiumApi"

	override void doGenerate(Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context) {
		val fileName = resource.URI.lastSegment.toString.replaceFirst("\\.feature","") 
		val path = PKG.replace('.','\\')
		for (e : resource.allContents.toIterable.filter(Scenario)) {
			fsa.generateFile(
				path + "\\" + fileName + "_" + e.sequence + ".java",
				e.convertJava(fileName)
			)
		}

	}
	
	// Get Java Class
	def CharSequence convertJava(Scenario scenario, String fileName){
		
		
		'''
package �PKG�;

/*
 No: �scenario.sequence�
 Description:
 �scenario.scenario�
 �new Date()�
*/ 

import edu.uned.missi.tfm.appiumlib.model.Expression;
import edu.uned.missi.tfm.test.impl.Scenario;

public class �fileName + "_" + scenario.sequence� extends Scenario{
								
	//
	//Given
	//
	public void given(){
		�IF scenario.given !== null�
			�IF scenario.given.activity !== null�
				startActivity(�scenario.given.activity.name�);
			�ENDIF�
			�IF scenario.given.validations !== null�
				�FOR v : scenario.given.validations�
					�IF v instanceof IsEnabled�
					      �isEnabledSTMT((v as IsEnabled))�
					�ENDIF�		
					�IF v instanceof IsVisible�
					      �isVisibleSTMT(v as IsVisible)�
					�ENDIF�																						
					�IF v instanceof OptionIsChecked�
					      �isOptionIsCheckedSTMT((v as OptionIsChecked))�
					�ENDIF�								
					�IF v instanceof ValueIsSelected�
					      �ValueIsSelectedSTMT((v as ValueIsSelected))�
					�ENDIF�								
					�IF v instanceof MessageIsDisplayed�
					      �MessageIsDisplayedSTMT((v as MessageIsDisplayed))�
					�ENDIF�								
					�IF v instanceof TextContains�
					       �TextContainsSTMT((v as TextContains))�
					�ENDIF�								
				�ENDFOR�
				
			�ENDIF�
		�ENDIF�
	}
				
	//
	// When
	//
	public void when(){	
		�IF scenario.when !== null�
			�IF scenario.when.statements !== null�
				�FOR s : scenario.when.statements�
					�IF s instanceof InputText�
					      �inputTextSTMT((s as InputText))�
					�ENDIF�								
					�IF s instanceof ButtonPress�
					      �buttonPressSTMT((s as ButtonPress))�
					�ENDIF�								
					�IF s instanceof OptionChoose�
					      �optionChooseSTMT((s as OptionChoose))�
					�ENDIF�								
					�IF s instanceof ValueSelect�
					      �valueSelectSTMT((s as ValueSelect))�
					�ENDIF�								
				�ENDFOR�
				
			�ENDIF�
		�ENDIF�
	}
				
	//
	// Then
	//
	public void then(){	
		�IF scenario.then !== null�
			�IF scenario.then.validations !== null�
				�FOR v : scenario.then.validations�
					�IF v instanceof IsEnabled�
					      �isEnabledSTMT((v as IsEnabled))�
					�ENDIF�								
					�IF v instanceof IsVisible�
					      �isVisibleSTMT(v as IsVisible)�
					�ENDIF�								
					�IF v instanceof OptionIsChecked�
					      �isOptionIsCheckedSTMT((v as OptionIsChecked))�
					�ENDIF�								
					�IF v instanceof ValueIsSelected�
					      �ValueIsSelectedSTMT((v as ValueIsSelected))�
					�ENDIF�								
					�IF v instanceof MessageIsDisplayed�
					      �MessageIsDisplayedSTMT((v as MessageIsDisplayed))�
					�ENDIF�								
					�IF v instanceof TextContains�
					      �TextContainsSTMT((v as TextContains))�
					�ENDIF�								
				�ENDFOR�
				
			�ENDIF�
		�ENDIF�
	}
				
} 
		'''
}
	

/* GIVEN */	
	def ValueIsSelectedSTMT(ValueIsSelected component) {		
		'''
		�IF component.op == "But"�
		valueNotSelected("�component.name�",�convertValue(component.value)�);
		�ELSE�
		valueSelected("�component.name�",�convertValue(component.value)�);
		�ENDIF�		
		'''
	}
	
	def isOptionIsCheckedSTMT(OptionIsChecked component) {
		'''
		�IF component.op == "But"�
		isNotChecked(�convertValue(component.value)�);
		�ELSE�
		isChecked(�convertValue(component.value)�);
		�ENDIF�		
		'''
	}
	
	def isEnabledSTMT(IsEnabled component) {
		'''
		�IF component.op == "But"�
		isNotEnabled("�component.name�");
		�ELSE�
		isEnabled("�component.name�");
		�ENDIF�		
		'''
	}

	def isVisibleSTMT(IsVisible component) {
		'''
		�IF component.op == "But"�
		isNotVisible("�component.name�");
		�ELSE�
		isVisible("�component.name�");
		�ENDIF�		
		'''
	}
	
	def MessageIsDisplayedSTMT(MessageIsDisplayed component) {
		'''
		�IF component.op == "But"�
		isMessageNotDisplayed(�convertValue(component.value)�);
		�ELSE�
		isMessageDisplayed(�convertValue(component.value)�);
		�ENDIF�		
		'''
	}

	def TextContainsSTMT(TextContains component) {
		'''
		�IF component.op == "But"�
		notCompare("�component.name�","Expression.�component.expression�,�convertValue(component.value)�);
		�ELSE�
		compare("�component.name�",Expression.�component.expression�,�convertValue(component.value)�);
		�ENDIF�		
		'''		
	}

/* WHEN */		

	def valueSelectSTMT(ValueSelect component) {
		'''
		selectValue("�component.name�",�convertValue(component.value)�);
		'''		
	}
	
	def optionChooseSTMT(OptionChoose component) {
		'''
		chooseOption(�convertValue(component.value)�);
		'''		
	}
	
	def buttonPressSTMT(ButtonPress component) {
		'''
		pressButton("�component.name�");
		'''		
	}
	
	def inputTextSTMT(InputText component) {
		'''
		type("�component.name�",�convertValue(component.value)�);
		'''		
	}
	
// Utility

	def String convertValue(String value) {
		return value.replace("\\","");
	}
	
}
