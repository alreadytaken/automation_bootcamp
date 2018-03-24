package com.globant.automation;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.ElementNotVisibleException;
import org.testng.annotations.Test;

public class SampleTest extends FunctionalTest{

    public SampleTest() {
        //Empty constructor as it is not needed
    }

    private static final Logger LOG;
    
   
    static {
        LOG = LogManager.getLogger(SampleTest.class);
    }
    
    

    @Test
    public void testExamen() throws ElementNotVisibleException {
        driver.get("https://amazon.com");
        String firstitem = "Ray Ban aviator sunglasses";
        AmazonHomePage page1 = new AmazonHomePage(driver);
        page1.inputintosearchbar(firstitem);
        AmazonSearchResults page2 = new AmazonSearchResults(driver);
        page2.click();
    }

    


}
