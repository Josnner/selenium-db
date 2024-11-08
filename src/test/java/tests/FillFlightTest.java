package tests;

import org.openqa.selenium.WebDriver;

import pages.FillFlights;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FillFlightTest {
	
	WebDriver driver;
	FillFlights fillFlights;
	
	@Before
	public void setUp() throws Exception {
		fillFlights = new FillFlights(driver);
		driver = fillFlights.ConectionChrome();
		fillFlights.visit("https://demo.guru99.com/test/newtours/reservation.php");	
	}

	@After
	public void tearDown() throws Exception {
		//driver.quit();
	}

	@Test
	public void test() {
		fillFlights.FillData();
	}

}
