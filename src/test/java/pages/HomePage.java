package pages;

import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	WebDriver driver;
	WebDriverWait wait;
	
    // Datos de conexión
    private static final String URL = "jdbc:mysql://localhost:3306/selenium"; // Cambia 'nombre_base_datos'
    private static final String USER = "root"; // Usuario MySQL por defecto en XAMPP
    private static final String PASSWORD = ""; // Si tienes contraseña, agrégala aquí

    public static Connection getConnection() {
        Connection connection = null;
        
        try {
            // Cargar el driver de MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Establecer la conexión
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexión a MySQL exitosa");
        } catch (ClassNotFoundException e) {
            System.out.println("Error al cargar el driver de MySQL: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Error al conectar a la base de datos: " + e.getMessage());
        }
        
        return connection;
    }
	
	public HomePage(WebDriver driver) {
		super();
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));// Inicializar el WebDriverWait aquí
	}
	
	public WebElement findElement(By locator) {
		return driver.findElement(locator);
	}

	public WebDriver ConectionChrome() {
		System.setProperty("webdriver.chrome.driver", "./src/test/resources/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		return driver;
	}
	
	public List<WebElement> findElements(By locator) {
		return driver.findElements(locator);		
	}
	
	public String getText(WebElement element) {
		return element.getText();		
	}
	
	public String getText(By locator) {
		return driver.findElement(locator).getText();		
	}
	
	//Función para escribir
	public void typy(String inputText, By locator) {
		driver.findElement(locator).sendKeys(inputText);		
	}
	
	public void click(By locator) {
		driver.findElement(locator).click();	
	}
	
	public void click(WebElement element) {
		//Acepta un webElement como parametro
		element.click();	
	}	
	
	public void visit(String url) {
		driver.get(url);		
	}
		
	public boolean isDisplayed(By locator) {
		try {
			return driver.findElement(locator).isDisplayed();
			
		} catch (org.openqa.selenium.NoSuchElementException e) {
			return false;
			// TODO: handle exception
		}
	}
	
	//Espera Explícitas
	public WebElement waitForElementToBeVisible(By locator, int timeoutInSeconds) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
	    return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public WebElement waitForElementToBeClickable(By locator, int timeoutInSeconds) {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
	    return wait.until(ExpectedConditions.elementToBeClickable(locator));
	}
	
	//Validación de Texto
	public boolean equalsText(By locator, String expectedText) {
	    String actualText = driver.findElement(locator).getText();
	    return actualText.equals(expectedText);
	}
	
	public boolean isCorrectPage(String expectedUrl) {
	    String currentUrl = driver.getCurrentUrl();
	    return currentUrl.equals(expectedUrl);
	}
	
	// Método para validar el texto de un elemento
    public void assertElementText(By locator, String expectedText, String message) {
        WebElement element = waitForElementToBeVisible(locator, 10);
        String actualText = element.getText();
        assertEquals(message, expectedText, actualText);
    }


}
