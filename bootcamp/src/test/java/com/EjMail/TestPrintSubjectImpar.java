package com.EjMail;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.PedidosYa.PedidosHomePage;
import com.PedidosYa.TestPedidosYa;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestPrintSubjectImpar {

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
		return new Object[][] { { "sebastianrodriguezprueba", "prueba1234" } };
	}

	@Test(dataProvider = "direccion")
	public void mailList(String user, String pass) throws InterruptedException {

		driver.get("http://www.gmail.com");
		driver.manage().window().maximize();

		GmailHomePage gmailHomePage = new GmailHomePage(driver);
		gmailHomePage.putEmail(user);
		gmailHomePage.putPassword(pass);

		GmailMailPage gmailMailPage = new GmailMailPage(driver);
		
		
		List<WebElement> resultados = gmailMailPage.getSubjects();

		List<Object> asuntos = new ArrayList<>();
		
		for (int i = 0; i < resultados.size(); i++) {
			String asunto = resultados.get(i).getText();

			if ((i % 2) == 1) {
				asuntos.add(asunto);
			}
		}

		LOG.info(asuntos);

	}
}
