package com.globant.automation;

import java.net.MalformedURLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import gmailPages.GmailMainPage;
import gmailPages.GmailPasswordPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class GmailTest {
	private static final Logger LOG;
	private WebDriver driver;

	static {
		LOG = LogManager.getLogger(GmailTest.class);
	}

	@BeforeMethod
	public void prepareTest() throws MalformedURLException {
		LOG.info("Iniciando test");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-infobars");
		options.addArguments("--incognito");
		
		driver = new ChromeDriver(options);
	}

	@AfterMethod
	public void cleanup() {
		driver.quit();
	}

	@BeforeClass()
	private void prepareClass() {
		WebDriverManager.chromedriver().setup();
	}

	@Test
	public void test() {
		driver.get("https://www.gmail.com");
		GmailMainPage main = new GmailMainPage(driver);
		GmailPasswordPage pass = main.ingresarEmail("ejemploglobantgonzalo@gmail.com");
		pass.ingresarPass("globant123");
	}
}
