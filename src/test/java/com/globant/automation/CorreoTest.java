package com.globant.automation;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CorreoTest {

	private static final Logger LOG;
	private WebDriver driver;

	static {
		LOG = LogManager.getLogger(GoogleTest.class);
	}

	@Test
	public void testML() {
		List<String> SubjectsToLog;
		SubjectsToLog = new ArrayList<>();
		driver.get("http://hotmail.com");
		CorreoLogInit LogInitPage = new CorreoLogInit(driver);
		credentialsInput CredentialsPage = LogInitPage.logInitClick();
		CredentialsPage.mailInputBox("cristianglobantbootcamp@outlook.com");
		credentialsPassword PasswordCredPage = CredentialsPage.nextBox();
		PasswordCredPage.passInputBox("GlobantBootcamp19");
		CorreoMain mainPage = PasswordCredPage.nextBox();
		SubjectsToLog = mainPage.displayAllSubjects();
		for (int i = 0; i <= SubjectsToLog.size(); i++) {
			if (i % 2 == 0) {
			} else {
				LOG.info(SubjectsToLog.get(i));// valor impar
			}
		}

	}

	@BeforeMethod
	public void prepareTest() {
		LOG.info("Prepare test");
		driver = new ChromeDriver();
	}

	@BeforeClass
	private void prepareClass() {
		LOG.info("Prepare class");
		WebDriverManager.chromedriver().setup();
	}
}
