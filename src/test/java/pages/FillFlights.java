package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FillFlights extends HomePage {
	
	//Selectores
	By imgFlightFinder = By.cssSelector("img[src='images/mast_flightfinder.gif']");
	By radioTrip = By.cssSelector("input[value='oneway']");
	By comboPass = By.xpath("//select[@name='passCount']");
	By comboFromPort = By.xpath("//select[@name='fromPort']");
	By comboFromMonth = By.xpath("//select[@name='fromMonth']");
	By comboFromDay = By.xpath("//select[@name='fromDay']");
	By comboToPort = By.xpath("//select[@name='toPort']");
	By comboToMonth = By.xpath("//select[@name='toMonth']");
	By comboToDay = By.xpath("//select[@name='toDay']");
	By radioServClass = By.xpath("//input[@value='Business']");
	By comboAirline = By.xpath("//select[@name='airline']");
	By btnFindFlights = By.xpath("//input[@name='findFlights']");
	By confirFlight = By.xpath("//tbody/tr[@valign='top']/td/p[@align='left']/font[@face='Arial, Helvetica, sans-serif']/b/font[1]");
	
	public FillFlights(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}


public void FillData() {
	waitForElementToBeVisible(imgFlightFinder,5);
	
	if (isDisplayed(imgFlightFinder)) {
		waitForElementToBeVisible(radioTrip, 3);
		click(radioTrip);
		waitForElementToBeClickable(comboPass, 3);
		seleccionarComboBoxValor(comboPass, "2");
		seleccionarComboBoxValor(comboFromPort, "Frankfurt");
		seleccionarComboBoxValor(comboFromMonth, "May");
		seleccionarComboBoxValor(comboFromDay, "3");
		seleccionarComboBoxValor(comboToPort, "London");
		seleccionarComboBoxValor(comboToMonth, "May");
		seleccionarComboBoxValor(comboToDay, "1");
		click(radioServClass);
		seleccionarComboBoxValor(comboAirline, "Unified Airlines");
		waitForElementToBeVisible(btnFindFlights,3);
		click(btnFindFlights);
		waitForElementToBeVisible(confirFlight, 5);
		assertElementText(confirFlight, "After flight finder - No Seats Avaialble  ", "Hay hacientos disponibles");
	}else {
		System.out.println("No se encuentra en la página Flight finder");
	}
	
	
}
}
