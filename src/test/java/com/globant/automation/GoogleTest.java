package com.globant.automation;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class GoogleTest {

    public GoogleTest() {

    }

    private static final Logger LOG;
    private WebDriver driver;

    static {
        LOG = LogManager.getLogger(GoogleTest.class);
    }

    @Test
    public void searchTest() throws InterruptedException {
        LOG.info("Search test");
       // driver.get("http://newtours.demoaut.com/");
    }
    
    @BeforeMethod
    public void prepareTest() throws MalformedURLException {
    	
    	//DesiredCapabilities caps = DesiredCapabilities.firefox();
        LOG.info("Prepare test");
        //RemoteWebDriver(new URL("http://127.0.0.1:4444/wd/hub"), caps);
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

    @DataProvider(name= "Authentication")
	public Object[][] provider(){
		
		LOG.info("Creamos la matriz");
		return new Object[][] {{"Columna de Darwin"},
								{"Triciclos"},
								{"Pistachos"}
								};
	
	}
	
	
	
	@Test(dataProvider = "Authentication")
	public void busquedasGoogle(String a) {
        driver.get("http://google.com.uy");
        
       
        WebElement txtBusqueda= SeleniumUtils.waitUntilClickable(By.name("q"), driver);
        txtBusqueda.sendKeys(a);   
       
                        
	}
	
	@Test
	public void comparoBusquedas() {
		 driver.get("http://google.com.uy");
		 WebElement txtBusqueda= SeleniumUtils.waitUntilClickable(By.name("q"), driver);
		 txtBusqueda.sendKeys("Pistachos");
		 
		 List<WebElement> resultadosGoogle = driver.findElements(By.xpath("//div[@class='rc']/h3[@class='r']/a"));	
	     List<String> auxG = new ArrayList();
	     for(int i=0; i<5; i++) {
	    	 auxG.add(resultadosGoogle.get(i).getText());
	     }
		 //driver.close();
		 
		 driver.get("https://www.bing.com/");
		 WebElement txtBusqueda2= SeleniumUtils.waitUntilClickable(By.name("q"), driver);
		 txtBusqueda2.sendKeys("Pistachos");
		 
		 List<WebElement> resultadosBing = driver.findElements(By.xpath("//div[@class='rc']/h2[@class='r']/a"));
		 List<String> auxB = new ArrayList();
		 for(int i=0; i<5; i++) {
	    	 auxG.add(resultadosGoogle.get(i).getText());
	     }
		 
		 for(int i=0; i<5; i++) {
			 Assert.assertEquals(auxG.get(i)==auxB.get(i), "Comparo Resultados");
			 
		 }
	}

}





/*
//Registro
WebElement register= driver.findElement(By.linkText("REGISTER"));
register.click();

//Completar Campos
WebElement txtFirstName= driver.findElement(By.name("firstName"));
txtFirstName.sendKeys("Astor");

WebElement txtLastName= driver.findElement(By.name("lasttName"));
txtLastName.sendKeys("Piazzolla");

WebElement submitButton= driver.findElement(By.name("register"));
submitButton.click();
*/