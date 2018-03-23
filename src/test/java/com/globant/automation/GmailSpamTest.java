package com.globant.automation;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.gmail.GmailInbox;
import pageObjects.gmail.GmailPassword;
import pageObjects.gmail.GmailUser;

public class GmailSpamTest {
	public GmailSpamTest() {
	}
	

	private static final Logger LOG;
	
	static {
		LOG = LogManager.getLogger(GmailSubjectTest.class);
	}
	
	protected static WebDriver driver;

	
	@Test
	public void gmailSubjectTest() {
		String email = "sblancotestingtest@gmail.com";
		String password = "@testing123";
		driver.get("http://www.gmail.com");
		GmailUser userPage = new GmailUser(driver);
		GmailPassword passwordPage = userPage.fillEmailField(email);
		GmailInbox inboxPage = passwordPage.fillPasswordField(password);
		
		}

		
		
		
	
	
	@BeforeClass
	public void prepareClass() {
		WebDriverManager.chromedriver().setup();

	}
	
	@BeforeMethod
	public void prepareTest() {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--incognito");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
	}
	@AfterMethod
	public void cleanUp() {
		driver.close();
	}
    
}
