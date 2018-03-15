package training;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EjemploTest {
	
	private static final Logger LOG = LogManager.getLogger(EjemploTest.class);
	
	private WebDriver driver;
	
	@Test
	public void metodoUno() {
		
		LOG.info("Test Uno");
	
	}

	@Test
	public void metodoDos() {
		LOG.info("Hola");
	
	
	}

	@BeforeMethod
	public void metodoTres() {

		LOG.info("Before Method");
		driver = new ChromeDriver();
		driver.get("http://google.com");
	}

	@AfterMethod
	public void metodoCuatro() {
		
		//LOG.info("After Test");
		driver.quit();
	
	}
	
	@BeforeClass
	public void metodoCinco() {
		
		LOG.info("Instalando Driver");
		WebDriverManager.chromedriver().setup();
		
	}
	
	@AfterClass
	public void metodoSeis() {
		
		LOG.info("After Class");
	
	}
	
	@DataProvider(name= "Authentication")
	public Object[][] provider(){
		
		LOG.info("Creamos la matriz");
		return new Object[][] {{"testuser_1","Test@123", "res1"},{"testuser_1","Test@123", "res2"}};
	
	}
	
	@Test(dataProvider = "Authentication")
	public void test(String sUsername, String password, String otro) {
		sUsername = "Juan";
		password = "Perez";
		otro = password;
		LOG.info(sUsername+ " " + password + " " + otro);
	}
	
	
	@Test(dataProvider = "Authentication")
	public void pruebaAssert(String a, String b, String c) {
		WebElement txtUsername = driver.findElement(By.name("userName"));
		Assert.assertTrue(a != b, a + " distinto de " + b);
		Assert.assertFalse(b == c, a + " igual a " + c);
		LOG.info("Prueba Assert");
	}
	
	/*
	 name="userName"
	 name="password"
	 name="login"
	 */
	
	

	

	

}
























/*
       ------- APUNTES DEL MIÉRCOLES 14  ----------
       
       1. Trabajando con Git
       Para hacer un commit en base a un archivo trabajado, se debe:
       
       git add nombreArchivo
       git commit -m "description"
       
		2. WebDriver
		Comunicación código-browser
*/
