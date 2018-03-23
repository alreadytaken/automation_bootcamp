package gmail;

import java.net.MalformedURLException;
import java.util.ArrayList;
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

public class GmailTest {
	private static final Logger LOG;
	static {
		LOG = LogManager.getLogger(GmailTest.class);
	}
	protected static WebDriver driver;

	@BeforeClass
	public void prepareClass() {
		WebDriverManager.chromedriver().setup();
	}

	@BeforeMethod
	public void prepareTest() throws MalformedURLException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-infobars --incognito");
		driver = new ChromeDriver();
	}

	@AfterMethod
	public void cleanUp() {
		driver.close();
	}

	@Test
	public void gmailTest() {
		driver.manage().window().maximize();
		driver.get("https://www.gmail.com");
		GmailHomePage emailPage = new GmailHomePage(driver);
		emailPage.enterInfo("globantejemplo@gmail.com");
		GmailHomePage2 passwordPage = new GmailHomePage2(driver);
		passwordPage.enterInfo("globant123");
		GlobantMailPage subjectPage = new GlobantMailPage(driver);
		// List <String> retorno =subjectPage.getSubjects();
		// LOG.info(retorno);
		

	}

}
