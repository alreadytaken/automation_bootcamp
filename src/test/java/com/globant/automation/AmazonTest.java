package com.globant.automation;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonTest {

	private static final Logger LOG;
	private WebDriver driver;

	static {
		LOG = LogManager.getLogger(AmazonTest.class);
	}

	@Test(dataProvider = "terminosBusqueda")
	public void testAmazon(String terminoABuscar) {
		driver.get("http://www.amazon.com");
		AmazonMain MainSite = new AmazonMain(driver);
		AmazonInItem InItemSite = MainSite.ingresarTerminoBusqueda(terminoABuscar);
		AmazonReviews Reviews = InItemSite.clickFirstItem();
		TopReviews TopRevs = Reviews.getReviews();
		String positiveRev =TopRevs.getNegativeReview();
		String negativeRev =TopRevs.getNegativeReview();
		LOG.info(positiveRev);
		LOG.info(negativeRev);
	}

	@BeforeMethod
	public void prepareTest() {
		LOG.info("Prepare test");
		driver = new FirefoxDriver();
	}

	@BeforeClass
	private void prepareClass() {
		WebDriverManager.firefoxdriver().setup();
	}

	@DataProvider(name = "terminosBusqueda")
	public Object[][] provider() {
		return new Object[][] { { "RayBan aviator sunglasses" }, { "Levi's 501 men original" },
				{ "Nike Air Force 1" } };
	}
}
