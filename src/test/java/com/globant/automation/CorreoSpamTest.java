package com.globant.automation;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CorreoSpamTest {

	private static final Logger LOG;
	private WebDriver driver;

	static {
		LOG = LogManager.getLogger(GoogleTest.class);
	}

	@Test(dataProvider = "mailsParaSpamear")
	public void testML(String correo) {
		driver.get("http://hotmail.com");
		CorreoLogInit LogInitPage = new CorreoLogInit(driver);
		credentialsInput CredentialsPage = LogInitPage.logInitClick();
		CredentialsPage.mailInputBox("cristianglobantbootcamp@outlook.com");
		credentialsPassword PasswordCredPage = CredentialsPage.nextBox();
		PasswordCredPage.passInputBox("GlobantBootcamp19");
		CorreoMain mainPage = PasswordCredPage.nextBox();
		newMailPage sendEmailPage = mainPage.clickNewMail();
		sendEmailPage.insertReciever(correo);
		sendEmailPage.insertSubject("No soy SPAM");
		sendEmailPage.insertBody("Toma un regalito");
		sendEmailPage.mailSend();
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

	@DataProvider(name = "mailsParaSpamear")
	public Object[][] provider() {
		return new Object[][] { { "santiago.caamano@globant.com" }, { "carlos.cadena@globant.com" }, { "gabriel.caamano@globant.com" },{ "federico.moreira@globant.com" }};
	}
}
