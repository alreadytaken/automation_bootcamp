package com.globant.automation;

import java.awt.List;
import java.net.MalformedURLException;

import javax.xml.xpath.XPath;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.By.ByXPath;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleTest {

	public GoogleTest() {

	}

	private static final Logger LOG;
	private WebDriver driver;

	static {
		LOG = LogManager.getLogger(GoogleTest.class);
	}

	@DataProvider(name = "Busqueda")
	public Object[][] provider() {
		return new Object[][] { { "Casas" }, { "Autos" }, { "Barcos" } };
	}

	@Test(dataProvider = "Busqueda")
	public void testBusqueda(String buscar) {
		LOG.info("Test busqueda");
		driver.get("https://www.google.com/");
		//WebElement txtSearch = driver.findElement(By.id("lst-ib"));
		WebElement txtSearch = SeleniumUtils.waitUntilClickable(By.id("lst-ib"), driver);
		txtSearch.sendKeys(buscar);
		txtSearch.submit();
		//WebElement e = (new WebDriverWait(driver, 10)).until(ExpectedConditions.elementToBeClickable(By.name("q")));
		SeleniumUtils.waitUntilClickable(txtSearch, driver);
		//List<WebElement> resultados = driver.findElements(By.xpath("//h3[@class='r']/a"));
	}

	/*
	 * @Test public void searchTest() throws InterruptedException {
	 * LOG.info("Search test"); driver.get("http://newtours.demoaut.com/");
	 * WebElement txtUsername = driver.findElement(By.name("userName")); WebElement
	 * txtPassword = driver.findElement(By.name("password"));
	 * txtUsername.sendKeys("usuario"); txtPassword.sendKeys("pass"); WebElement
	 * btnLogIn = driver.findElement(By.name("login")); btnLogIn.click(); }
	 */

	@BeforeMethod
	public void prepareTest() throws MalformedURLException {
		LOG.info("Prepare test");
		// DesiredCapabilities caps = DesiredCapabilities.firefox();
		// driver = new RemoteWebDriver(new URL("http://127.0.0.1:4444/wd/hub"), caps);
		//driver = new FirefoxDriver();
		 driver = new ChromeDriver();
	}

	@AfterMethod
	public void cleanup() {
		driver.quit();
	}

	@BeforeClass()
	private void prepareClass() {
		LOG.info("Prepare class");
		//WebDriverManager.firefoxdriver().setup();
		 WebDriverManager.chromedriver().setup();
	}
}
