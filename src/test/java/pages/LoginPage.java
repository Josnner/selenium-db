package pages;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

//Feature coneccion base de datos
public class LoginPage extends HomePage{
	By userName = By.name("userName");
	By password = By.name("password");
	By btnSubmit = By.name("submit");
	
	//Go to Login
	By linkLogin = By.cssSelector("a[href='login.php']");
	
	//Img home ARUBA
	By imgAruba = By.cssSelector("img[alt='Featured Destination: Aruba']");

	//Texto Login
	By textLogin = By.cssSelector("tbody tr td h3");
	
	//Boton Flights
	By btnFlights = By.cssSelector("body > div:nth-child(5) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(1) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(1) > table:nth-child(1) > tbody:nth-child(1) > tr:nth-child(1) > td:nth-child(1) > table:nth-child(2) > tbody:nth-child(1) > tr:nth-child(2) > td:nth-child(2) > a:nth-child(1)");
	
	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	
	public void checkHome() {
		if(isCorrectPage("https://demo.guru99.com/test/newtours/index.php")) {
			if(isDisplayed(imgAruba)) {
			
		}else {
			System.out.println("La img de Aruba no esta disponible");
		}
		}else {
			System.out.println("No estamos en la HomePage");
		}
		
	}
	
	public void goToLogin() {
		click(linkLogin);
		
	}
	
	public void Login(String query) {
		if(isDisplayed(linkLogin)) {
			
			if(isDisplayed(userName)) {
				
				{
			        try (Connection connection = getConnection();
			             Statement stmt = connection.createStatement();
			             ResultSet rs = stmt.executeQuery(query)) {
			            
			            while (rs.next()) {
			                	typy(rs.getString(1), userName);
			                	typy(rs.getString(2), password);
			                	click(btnSubmit);
			    				waitForElementToBeVisible(textLogin, 5);
			    				assertElementText(textLogin, "Login Successfully", "No se encuentra en la pagina de login");
			                	click(btnFlights);
			                	   
			            }
			        } catch (SQLException e) {
			            System.out.println("Error en la operación de base de datos: " + e.getMessage());
			        }
			    }
				
			/*	typy("qualityadmin", userName);
				typy("pass1", password);
				click(btnSubmit);
				waitForElementToBeVisible(textLogin, 5);
				assertElementText(textLogin, "Login Successfully", "No se encuentra en la pagina de login");
			*/
			}
		
	}else {
		System.out.println("No se encuentra en la pagina de login");
		}
	}


}
