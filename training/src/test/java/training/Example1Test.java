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
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Example1Test {
	private WebDriver driver;
	private static final Logger LOG = LogManager.getLogger(Example1Test.class);

	@BeforeClass
	public void BeforeClass() {
		LOG.info("Instalando el driver");
		WebDriverManager.firefoxdriver().setup();
	}

	@BeforeMethod
	public void BeforeTest() {
		LOG.info("BeforeTest");
		driver = new FirefoxDriver();
	}
	//name="userName"
	//name="password"
	//name="login"
	@AfterClass
	public void AfterClass() {
		LOG.info("Final");
	}

	@AfterMethod
	public void AfterTest() {
		LOG.info("AfterTest");
		driver.quit();
	}

	@DataProvider(name = "Authentication")
	public static Object[][] credentials() {
		return new Object[][] { { "testuser_1", "Test@123", "Juan" }, { "testuser_2", "Test@123", "Pedro" } };
	}

	@Test(dataProvider = "Authentication")
	public void test(String sUsername, String sPassword, String sName) {
		LOG.info(sUsername);
		LOG.info(sPassword);
		LOG.info(sName);
		Assert.assertEquals(sUsername, "testuser_1", "Valor Username and testuser_1 are the same");

	}

	@Test
	public void metodo1() {
		LOG.info("Test1");
		WebElement txtUsername = driver.findElement(By.name("userName"));
	}

	@Test
	public void metodo2() {
		LOG.info("Test2");
	}
}
