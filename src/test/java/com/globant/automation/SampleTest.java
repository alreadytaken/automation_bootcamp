package com.globant.automation;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.AmazonHomePage;
import pageObjects.AmazonObjectPage;
import pageObjects.AmazonSearchPage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SampleTest {

    public SampleTest() {
        //Empty constructor as it is not needed
    }

    private static final Logger LOG;
    private WebDriver driver;

    static {
        LOG = LogManager.getLogger(SampleTest.class);
    }

    @Test
    public void testExamen() {
    	driver.manage().window().maximize();
    	driver.get("https://amazon.com");
        AmazonHomePage homePage = new AmazonHomePage(driver);
        homePage.enterInfo("Ray Ban aviator sunglasses");
        AmazonSearchPage searchPage = new AmazonSearchPage(driver);
        searchPage.enter();
        AmazonObjectPage objectPage = new AmazonObjectPage(driver);
        objectPage.moreComments(); 
        
    }
    
	@DataProvider(name = "Busqueda")
	public Object[][] provider() {
		return new Object[][] { { "Ray Ban aviator sunglasses" }, { "Levi's 501 men original" },{"Nike Air Force 1"} };
	}

    @BeforeMethod
    public void setUp() {
        LOG.info("Inicializando driver");
        ChromeOptions opts = new ChromeOptions();
        opts.addArguments("--incognito");
        opts.addArguments("--test-type");
        opts.addArguments("--no-sandbox");
        driver = new ChromeDriver(opts);
    }

    @BeforeClass
    public void setUpClass() {
        LOG.info("Asegurando la instalacion de ChromeDriver");
        WebDriverManager.chromedriver().setup();
    }

    @AfterMethod
    public void tearDown() {
        LOG.info("Finalizando el test");
        driver.quit();
    }


}
