package ExamenBrunoZerpa;

import java.net.MalformedURLException;

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

import io.github.bonigarcia.wdm.WebDriverManager;


public class TestAmazon {

	
	private static final Logger LOG;
    private WebDriver driver;
    
    static {
        LOG = LogManager.getLogger(TestAmazon.class);
    }
    
 
    @BeforeClass
    private void prepareClass() {
        LOG.info("Prepare class");
        WebDriverManager.chromedriver().setup();
    }
    
    @BeforeMethod
    public void prepareTest() throws MalformedURLException {
    	
    	ChromeOptions options = new ChromeOptions();
    	options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
   }

    @DataProvider(name= "Authentication")
	public Object[][] provider(){
		
		return new Object[][] {{"Ray Ban aviator sunglasses"}, {"Levi's 501 men original"}, {"Nike Air Force 1"}};
    }
    
	@Test(dataProvider = "Authentication")
	public void comparoBusquedas(String searchText) {
		
		driver.get("http://amazon.com");
		AmazonHomePage amazonHome = new AmazonHomePage(driver);
		SearchResultPage resultsPage = amazonHome.searchItem(searchText);
		ProductReviewPages viewProduct = resultsPage.clickFisrt();
		TopReviews topPositivesAndNegatives = viewProduct.goTopRevies();
		LOG.info("Positive: " +topPositivesAndNegatives.getNegative());
		LOG.info("Negative: " + topPositivesAndNegatives.getPositive());
	}

    @AfterMethod
    public void cleanup() {
        driver.quit();
    }
}
