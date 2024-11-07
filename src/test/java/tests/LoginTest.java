package tests;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.LoginPage;

public class LoginTest {
	WebDriver driver;
	LoginPage loginPage;	
	//private boolean loginRequestSuccess = false;

	@Before
	public void setUp() throws Exception {
		loginPage = new LoginPage(driver);
		driver = loginPage.ConectionChrome(); // DataBase
		driver = loginPage.ConectionChrome();
		loginPage.visit("https://demo.guru99.com/test/newtours/index.php");
		loginPage.checkHome();
		
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void test() {
		
		loginPage.goToLogin();
		loginPage.Login("SELECT * FROM credenciales");
		// Valida si la petición al backend fue exitosa
        //assertEquals("La solicitud de login debería haber tenido éxito", true, loginRequestSuccess);
    
	}

}
