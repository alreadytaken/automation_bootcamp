package PedidosYa;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import io.github.bonigarcia.wdm.WebDriverManager;

public class PedidosYaTestPage {
	
	private WebDriver driver;
	//private WebDriver driver2;
	
	private static final Logger LOG;
    
    static {
        LOG = LogManager.getLogger(PedidosYaTestPage.class);
    }
    
    @BeforeMethod
    public void prepareTest() {
        LOG.info("Prepare test");
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
	
    @Test
    public void normalTest() {
    	
    	String address = "Vera 1666";
    	String food = "milanesa";
    	String price = null;
    	
    	driver.get("https://pedidosya.com");
    	
    	PedidosYaHomePage testHome = new PedidosYaHomePage(driver);
    	PedidosYaSearchPage testSearch ;
    	PedidosYaSelectPage testSelect;
    	PedidosYaConfirmPage testConfirm;
    	PedidosYaPopUpPage testPopUp;
    	
    	testSearch = testHome.enterPage();
    	testSearch.typeOrder(address, food);
    	testSearch.sendOrder();
    	
    	testSelect = testSearch.confirmOrder();
    	price = testSelect.savePrice(price);
    	   	
    	testConfirm = testSelect.selectPromo();
    	testConfirm.confirmPromo();
    	
    	testPopUp = testConfirm.orderFood();
    	
    	
    	
    }
}
