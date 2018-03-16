package com.globant.automation;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class GoogleTest {

	public GoogleTest() {

	}

	private static final Logger LOG;
	private WebDriver driver;

	static {
		LOG = LogManager.getLogger(GoogleTest.class);
	}

	@Test(dataProvider = "Search")
	public void searchTest(String Search) throws InterruptedException {
		LOG.info("Search test");
		driver.get("https://google.com");
		WebElement txtSearch = SeleniumUtils.waitUntilClickable(By.name("q"), driver);
		txtSearch.sendKeys(Search);
		txtSearch.sendKeys(Keys.ENTER);
		txtSearch.submit();
		WebElement firstSearch = driver.findElements(By.xpath("//h3[@class=-'r'|/a");
		//List<WebElement> resultados = driver;
		//firstSearch.click();
	}

	@DataProvider(name = "Search")
	public Object[][] provider() {
		return new Object[][] { { "autos" }, { "computadoras" }, { "amazon" } };
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
