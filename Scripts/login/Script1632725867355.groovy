import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import utileria.accion as accion

TestData loginData = findTestData("logindata");

int rows = loginData.getRowNumbers();

String email;
String password;

for(int i = 1; i<= rows; i++) {
	String status = loginData.getObjectValue('ejecutar', i).toString();
	//if status = true
	if(status.equalsIgnoreCase("TRUE")) {
		
		WebUI.openBrowser("https://dev.deel.wtf/login")
		WebUI.maximizeWindow();
		
		//if the email bar is present
		if(accion.present("//input[@name='email']")) {
			
			email = loginData.getObjectValue('email', i).toString();
			password = loginData.getObjectValue("password", i).toString();
			
			accion.agregarPuntoDeVerificacion("Login Screen is displayed", true, true);
			
			//insert data
			accion.setText("//input[@name='email']", email);
			
			accion.setText("//input[@type='password']", password);
			
			//click submit button
		
			accion.click("//button[@class='button mt-10 w-100']");
			
			//if this element appear
			if(accion.present("//h1[@class='mr-6']")) {
				accion.agregarPuntoDeVerificacion("element appear", true, true);
			
			}
			else {
				accion.agregarPuntoDeVerificacion("Element is not in the page", true, true);
			}
		
		}
		else {
			accion.agregarPuntoDeVerificacion("Login Screen isn't displayed", true, true);
		
		}
	}
}