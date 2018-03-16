package com.globant.automation;

import java.net.MalformedURLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class NewTourTest {

	private static final Logger LOG;
	private WebDriver driver;

	static {
		LOG = LogManager.getLogger(GoogleTest.class);
	}
	//DATA PROVIDER PARA EL SIGN IN
	@DataProvider(name = "Users")
	public Object[][] provider() {
		return new Object[][] { { "Pepe", "Pepe123" }, { "Juan", "Juan123" }, { "Hola", "Hola123" },
				{ "Arturo", "Arturo123" }, { "Jose", "Jose123" } };
	}
	//DATA PROVIDER PARA EL REGISTRO
	@DataProvider(name = "Register")
	public Object[][] provider2() {
		return new Object[][] {
				{ "Jose", "Castro", "111 111 111", "ejemplo@gmail.com", "Mercedes 2222", "Montevideo", "Montevideo",
						"97000", "Pepe", "Pepe123" },
				{ "Juan", "Castro", "111 111 111", "ejemplo@gmail.com", "Mercedes 2222", "Montevideo", "Montevideo",
						"97000", "Juan", "Juan123" } };
	}
	//TEST DE REGISTRO
	@Test(dataProvider = "Register" )
	public void Register(String name, String lastName, String tel, String Email, String adress, String city, String state, String cP, String user, String password) throws InterruptedException {
		driver.get("http://newtours.demoaut.com/mercuryregister.php");
		WebElement firstName = SeleniumUtils.waitUntilClickable(By.name("firstName"), driver);
		LOG.info("Espero por la pagina");
		firstName.sendKeys(name);
		
	}

	@BeforeMethod
	public void prepareTest() throws MalformedURLException {
		LOG.info("Prepare test");
		driver = new ChromeDriver();
	}

	@AfterMethod
	public void cleanup() {
		driver.quit();
	}

	@BeforeClass
	private void prepareClass() {
		LOG.info("Prepare class");
		WebDriverManager.chromedriver().setup();
	}
}
