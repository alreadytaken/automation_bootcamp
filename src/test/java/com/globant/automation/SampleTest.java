package com.globant.automation;

import io.github.bonigarcia.wdm.WebDriverManager;

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

public class SampleTest {

    public SampleTest() {
        //Empty constructor as it is not needed
    }

    private static final Logger LOG;
    private WebDriver driver;

    static {
        LOG = LogManager.getLogger(SampleTest.class);
    }

    
    @DataProvider(name="productos")
		public Object [][] provider() {
		 return new Object [][] {{"RayBan aviator sunglasses"},{"Levi's 501 men original"},{"Nike air force 1"}};
	}
	
	    
    @Test(dataProvider="productos")
    public void testExamen(String producto) {
        driver.get("https://amazon.com");
        
        AmazonHomePage amazonHomePage = new AmazonHomePage(driver);
        amazonHomePage.sendData(producto);
       
        AmazonProductPages amazonProductPages = new AmazonProductPages(driver);
        amazonProductPages.clickProducto();
        
        AmazonProductPage amazonProductPage = new AmazonProductPage(driver);
        amazonProductPage.clickReview();
        
        AmazonReviewPage amazonReviewPage = new AmazonReviewPage(driver);
        List <WebElement> reviews = amazonReviewPage.getReviews();
        
        List <String> critic=new ArrayList<>();
        for(int i=0;i<reviews.size();i++) {
        String texto = reviews.get(i).getText();
        critic.add(texto);
        
        }
        
        LOG.info(critic);
        
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
