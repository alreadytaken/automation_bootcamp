package training;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObject.Home;

public class SeleniumTest {
	
    private static final Logger LOG = LogManager.getLogger(SeleniumTest.class);
    public WebDriver driver;

	@BeforeClass
	public void beforeclass() {
	}
	@BeforeMethod
	public void beforemethod() {
		  driver = new ChromeDriver();
	}
	@Test
	public void testmethod() {
		Home page = PageFactory.initElements(driver, Home.class);
		LOG.info("Testing Started");
		driver.get("http://newtours.demoaut.com/");
		page.sendKeysUsrField("santiago");
		page.sendKeysPwField("testing123");
		page.clickSigninButton();
		

	}

	@AfterMethod
	public void aftermethod() {
		driver.close();
	}

	@AfterClass
	public void afterclass() {
	}
}
