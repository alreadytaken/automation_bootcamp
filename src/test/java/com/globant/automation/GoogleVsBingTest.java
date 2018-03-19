package com.globant.automation;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleVsBingTest {
	
    private static final Logger LOG;
    private WebDriver driver;
    
    static {
        LOG = LogManager.getLogger(GoogleTest.class);
    }
    
    
    @Test (dataProvider = "terminosBusqueda")
    public void metodoTestGvsB(String terminoBusqueda){
	driver.get("https://google.com");
	GoogleMain PaginaGoogle = new GoogleMain(driver);
	GoogleSearchResult pageResults = PaginaGoogle.search(terminoBusqueda);
	List<String> resultados = pageResults.getResults();
	
    }
    
	@BeforeMethod
	public void prepareTest() {
	    LOG.info("Prepare test");
	    driver = new FirefoxDriver();
	}
	@BeforeClass
	private void prepareClass() {
	    LOG.info("Prepare class");
	    WebDriverManager.firefoxdriver().setup();
	}
	@DataProvider(name = "terminosBusqueda")
	public Object[][] provider() {
		return new Object[][] { {"Futbol"},{"Basquetball"},{"Tenis"},{"Golf"},{"Ping Pong"} };
	}
}
