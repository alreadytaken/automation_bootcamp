package training;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EjemploTest {
	private static final Logger LOG = LogManager.getLogger(EjemploTest.class);
	private WebDriver driver;

	@Test
	public void MetodoEjemplo() {
		LOG.info("Metodoejemplo1 Test");
		WebElement txtUsername = driver.findElement(By.name("userName"));
		// name=userName
		// name=password
		// name=login
		// System.out.println("Metodoejemplo1 Test");
	}

	@BeforeMethod
	public void MetodoEjemplo2() {
		driver = new ChromeDriver();
		LOG.info("Metodoejemplo2 BeforeMethod");
		// System.out.println("Metodoejemplo2 BeforeMethod");
	}

	@AfterMethod
	public void MetodoEjemplo3() {
		// driver.quit();
		LOG.info("Metodoejemplo3 AfterMethod");
		// System.out.println("Metodoejemplo3 AfterMethod");
	}

	@BeforeClass
	public void MetodoEjemplo4() {
		LOG.info("Instalando Driver");
		WebDriverManager.chromedriver().setup();
		LOG.info("Metodoejemplo4 BeforeClass");
		// System.out.println("Metodoejemplo4 BeforeClass");
	}

	@AfterClass
	public void MetodoEjemplo5() {
		LOG.info("Metodoejemplo5 AfterClass");
		// System.out.println("Metodoejemplo5 AfterClass");
	}

	@Test(dataProvider = "Authentication")
	public void MetodoEjemplo6(String sUsername, String sPassword, String sInfo) {
		LOG.info(sUsername);
		LOG.info(sPassword);
		LOG.info(sInfo);
		// System.out.println(sUsername);
		// System.out.println(sPassword);
		// System.out.println(sInfo);
		Assert.assertEquals(sUsername, sInfo, "Verifico los nombres");
	}

	@Test(dataProvider = "Authentication")
	public void MetodoEjemplo7(String sUsername, String sPassword, String sInfo) {
		LOG.info(sUsername);
		LOG.info(sPassword);
		LOG.info(sInfo);
		Assert.assertEquals(sUsername, sInfo, "Verifico los nombres");

	}

	@DataProvider(name = "Authentication")
	public Object[][] provider() {
		return new Object[][] { { "Juan", "Test@123", "Juan" }, { "Juan", "Test@123", "Pedro" },
				{ "Juan", "Test@123", "Juan" } };
	}
}
