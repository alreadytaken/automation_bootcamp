package utils;

import java.net.MalformedURLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import test.compare.results.CompareResultCase;

public class SobreDataProvider {
	
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
		
	
	}

}
