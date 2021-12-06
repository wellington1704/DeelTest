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
//calling the login Test case
WebUI.callTestCase(findTestCase("Test Cases/login"), [:], FailureHandling.STOP_ON_FAILURE);

// exiting alternative windows
accion.click("//*[@class='button button-close']");
//Creating contact
accion.click("//p[contains(text(),'Create A Contract')]");

//selecting the type of contract i'm going to create

if (accion.present("//h4[contains(text(),'Fixed Rate')]")) {
	accion.click("//h4[contains(text(),'Fixed Rate')]");
	accion.agregarPuntoDeVerificacion("The type of contract was clicked", true, true);
}else {
	accion.agregarPuntoDeVerificacion("This type of contract wasn't clicked",true, true);
}

//if text appear, then start filling out the form
if(accion.present("//h2[contains(text(),'Creating a fixed contract')]")) {
	
	//providing the following information : Contract name;
	accion.setText("//input[@name='name']", "Manolo Dipre");
	// Job title
	accion.click("//input[@name='jobTitle']");
	accion.click("//p[contains(text(),'Accountant')]")
	//seniority level
	accion.click("//div[@class='select__value-container css-1hwfws3']");
	accion.click("//div[contains(text(),'Junior (Individual Contributor Level 1)')]");
	//defining scope
	accion.click("//h6[contains(text(),'Saved/predefined scopes')]");
	accion.click("//div[contains(text(), 'Account Executive')]");
	//clicking on next
	accion.click("//div[contains(text(),'next')]");
	if(accion.present("//input[@name='rate']")) {
		accion.agregarPuntoDeVerificacion("Next was Clicked", true, true);
	}else {
		accion.agregarPuntoDeVerificacion("Next was not Clicked", true, true);
	}
	//set rate
	accion.setText("//input[@name='rate']", "199000")
	//clicking on next
	accion.click("//div[contains(text(),'next')]");
	if(accion.present("//div[@class='select__input']")) {
		accion.agregarPuntoDeVerificacion("Next was Clicked", true, true);
	}else {
		accion.agregarPuntoDeVerificacion("Next was not Clicked", true, true);
	}
	
	//clicking on next
	accion.click("//div[contains(text(),'next')]");
	if(accion.present("//*[contains(text(), 'add a termination date')]")) {
		accion.agregarPuntoDeVerificacion("Next was Clicked", true, true);
	}else {
		accion.agregarPuntoDeVerificacion("Next was not Clicked", true, true);
	}
	//cliking on next
	accion.click("//div[contains(text(),'next')]");
	if(accion.present("//div[@class='select__input']/input")) {
		 accion.agregarPuntoDeVerificacion("Next was Clicked", true, true);
	 }else {
		 accion.agregarPuntoDeVerificacion("Next was not Clicked", true, true);
	 }
	// Contractor residence
	accion.setText("//div[@class='select__input']/input", "Dominican Republic");
	
	WebUI.sendKeys(accion.makeTestObjectFromXpath("//div[@class='select__input']/input"), Keys.chord(Keys.ENTER));
	//clicking on create contract
	accion.click("//div[contains(text(), ' create contract')]");
	
	accion.agregarPuntoDeVerificacion("The contract was correctly created", true, true);
	
}else {
	accion.agregarPuntoDeVerificacion("The contrat was not created", true, true);
}