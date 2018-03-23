package com.EjMail;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.PedidosYa.TestPedidosYa;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestSpam {

	public static WebDriver driver;
	public static Logger LOG = LogManager.getLogger(TestPedidosYa.class);

	@BeforeMethod
	public void prepareTest() {
		LOG.info("Prepare test");

		// ChromeOptions options = new ChromeOptions();
		// options.addArguments("--disable-infobars,--incognito");

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

	@DataProvider(name = "direccion")
	public Object[][] provider() {
		return new Object[][] { { "sebastianrodriguezprueba", "prueba1234","carlos.cadena@globant.com;gabriel.caamano@globant.com","Toma un regalito","No soy Spam" } };
	}

	@Test(dataProvider = "direccion")
	public void mailList(String user, String pass,String to,String body,String subject) throws InterruptedException {

		driver.get("http://www.gmail.com");
		driver.manage().window().maximize();

		GmailHomePage gmailHomePage = new GmailHomePage(driver);
		gmailHomePage.putEmail(user);
		gmailHomePage.putPassword(pass);

		GmailMailPage gmailMailPage = new GmailMailPage(driver);
        gmailMailPage.clickRedact();
        
        GoogleRedactMail googleRedactMail= new GoogleRedactMail(driver);
        
        googleRedactMail.putTo(to);
        googleRedactMail.putSubject(subject);
        googleRedactMail.putBody(body);
        googleRedactMail.clickSend();
		
        
        
        
	
	}	
}
