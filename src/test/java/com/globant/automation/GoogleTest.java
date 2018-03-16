package com.globant.automation;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
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
import org.testng.Assert;
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
		List<String> resultadosGoogle = new ArrayList<>();
		List<String> resultadosBing = new ArrayList<>();
		LOG.info("Google");
		driver.get("https://google.com");
		WebElement txtSearchG = SeleniumUtils.waitUntilClickable(By.name("q"), driver);
		LOG.info("Espero por google");
		txtSearchG.sendKeys(Search);
		txtSearchG.sendKeys(Keys.ENTER);
		SeleniumUtils.waitUntilClickable(By.xpath("//h3[@class='r']/a"), driver);
		List<WebElement> resultados = driver.findElements(By.xpath("//h3[@class='r']/a"));
		for (int i = 0; i < 5; i++) {
			resultadosGoogle.add(resultados.get(i).getText());
		}
		LOG.info("Bing");
		driver.get("https://bing.com");
		WebElement txtSearchB = SeleniumUtils.waitUntilClickable(By.id("sb_form_q"), driver);
		txtSearchB.sendKeys(Search);
		txtSearchB.sendKeys(Keys.ENTER);
		SeleniumUtils.waitUntilClickable(By.xpath("//li[@class='b_algo']/h2/a"), driver);
		List<WebElement> resultados2 = driver.findElements(By.xpath("//li[@class='b_algo']/h2/a"));
		for (int i = 0; i < 5; i++) {
			resultadosBing.add(resultados2.get(i).getText());
		}
		
		for (int i = 0; i < 5; i++) {
			LOG.info("Resultado Google: " + resultadosGoogle.get(i));
			LOG.info("Resultado Bing: " + resultadosBing.get(i));
			Assert.assertEquals(resultadosGoogle.get(i),resultadosBing.get(i));
		}
		;

	}

	@DataProvider(name = "Search")
	public Object[][] provider() {
		return new Object[][] { { "Pepe" },{ "Juan" },{ "Hola" },{ "Arturo" },{ "Jose" } };
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
