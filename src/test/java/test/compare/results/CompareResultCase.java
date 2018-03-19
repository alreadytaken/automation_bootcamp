package test.compare.results;

import java.net.MalformedURLException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import io.github.bonigarcia.wdm.WebDriverManager;

public class CompareResultCase{

	private static final Logger LOG;
    private WebDriver driver;

    static {
        LOG = LogManager.getLogger(CompareResultCase.class);
    }
    
    @BeforeClass
    private void prepareClass() {
        LOG.info("Prepare class");
        WebDriverManager.chromedriver().setup();
    }
    
    @BeforeMethod
    public void prepareTest() throws MalformedURLException {
    	
        driver = new ChromeDriver();
    }
    
    @AfterMethod
    public void cleanup() {
        driver.quit();
    }
    
	@DataProvider(name= "Authentication")
	public Object[][] provider(){
		
		return new Object[][] {{"Pistachos"}};
    }
    
	@Test(dataProvider = "Authentication")
	public void comparoBusquedas(String a) {
		
		driver.get("http://google.com.uy");
		GoogleSearchPage googleHome = new GoogleSearchPage(driver);
		GoogleResultsPage googleResults = googleHome.realizeGoogleSearch(a);
		List<String> googleFive = googleResults.ListFirstFive();
		
		driver.get("http://bing.com");
		BingSearchPage bingHome = new BingSearchPage(driver);
		BingResultsPage bingResults = bingHome.realizeBingSearch(a);
		List<String> bingFive = bingResults.ListFirstFive();
		
		Assert.assertNotEquals(googleFive, bingFive, "Resultados Distintos");
	}
	
}
