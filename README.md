# TFM-UNED
aatDSL - DSL For creating mobile application testing

El proyecto corresponde a los fuentes utilizado para presentar mi trabajo de fin de Master de UNED

--------------------------------------------------------------------------------------------------

aatDSL - Android Application Testing DSL
Es un proyecto escrito sobre XText para genera un DSL basado en Gherkin que permite crear escenarios de pruebas de aplicaciones móviles.

AppiumApi - Librerias implementa API para invocar Appium
Los escenarios escritos en aatDSL se transforman en programas Java. Esto programas, para interactuar con Appium (motor de ejecución de las pruebas), usan elementos que solapan o abstraen la funcionalidad de Appium. Este API permite implementar una lógica uno a uno, entre las funcionalidades Appium a uilizar, y las instrucciones DSL permitidas. Así la implementación del interprete de ejecución es más fácil.


| ----------------------- | ---------------------- |
|     Término	          |             DSL        |
|  :---                   |  :---                  |
|   Característica	  |     Feauture           |
|   Escenario	          |       Scenario         |
|   Descripción	          | Scenario Description   |
|   Precondiciones	  |       Given            |
|   Pasos de Prueba	  |       When             |
|   Resultados	          |       Then             |
| ----------------------- | ---------------------- |    

+ ----------------------- + ---------------------- + ----------------------------------- +
        Elemento	                  Acción	                    Descripción
+ ----------------------- + ---------------------- + ----------------------------------- +
| TextView	                    type                    
|                               input	                  Ingreso de datos desde el teclado.
+ ----------------------- + ---------------------- + ----------------------------------- +
| Button	                      tap
|                               press                   Acción clic sobre el elemento.
|                               click	                  
+ ----------------------- + ---------------------- + ----------------------------------- +
|  CheckBox o RadioButton	      choose	                Seleccionar un valor
+ ----------------------- + ---------------------- + ----------------------------------- +
   ListView                  	  select	                Seleccionar un valor
+ ----------------------- + ---------------------- + ----------------------------------- +
  Toast Notification	          show
                                 see	                    Mostrar un mensaje de notificación
+ ----------------------- + ---------------------- + ----------------------------------- +

Elemento	Atributo	Descripción
TextView	Enabled	Indica si el componente se encuentra habilitado para ser utilizado
	Visible	Indica si el componente se encuentra visible
	Content	Indica el texto contenido
Button		
CheckBox o RadioButton	Checked	Indica si el elemento esta seleccionado o no.
ListView	Selected	Indica el texto que esta seleccionado en la lista de valores.
Notification	Name	Texto que se muestra en el componente de notificaciones


--------------------------------------------------------------------------------------------------
Ejemplo:
Feature:
	"Calcular el pago mensual de la hipoteca"

//
Scenario: 1
	"El usuario ingresar los datos requeridos, y seleccionar la opción de mese para indicar el plazo de la hipoteca"
Given:
	Option \"Importe del Préstamo" is checked
	But Option \"Cuota Mensual" is checked
When:
	I type \"1000" into Importe.del.Prestamo
	I type \"12" into Tasa.de.Interes
	I type \"240" into Plazo.Hipoteca
	I choose \"Mes"
	I press over Calcular
Then:
	Content Cuota.Mensual equals \"1200.17"
