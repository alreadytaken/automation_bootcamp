package com.globant.automation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
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

    }
    @Test(dataProvider = "terminosBusqueda")
	public void metodoEjemplo7(String terminoBusqueda) {
		LOG.info(terminoBusqueda);
        driver.get("https://google.com");
        WebElement e=SeleniumUtils.WaitUntilClickable(By.name("q"), driver);
		e.sendKeys(terminoBusqueda);
		e.sendKeys(Keys.ENTER);
		//WebElement resultado=SeleniumUtils.WaitUntilClickable(By.className("r"), driver);
		//resultado.click();
		WebElement resultado=SeleniumUtils.WaitUntilClickable(By.xpath("//div[@class='rc']/h3/a"), driver);
		resultado.click();
        
		//WebElement txtSearch = driver.findElement(By.id("lst-ib"));
		//txtSearch.sendKeys(terminoBusqueda);
		//txtSearch.sendKeys(Keys.ENTER);
		
			}
    

    @BeforeMethod
    public void prepareTest() {
        LOG.info("Prepare test");
        driver = new ChromeDriver();
    }

    @AfterMethod
    public void cleanup() {
       // driver.quit();
    }

    @BeforeClass
    private void prepareClass() {
        LOG.info("Prepare class");
        WebDriverManager.chromedriver().setup();
    }
    @DataProvider(name = "terminosBusqueda")
	public Object[][] provider() {
		return new Object[][] { {"Futbol"},{"Basquetball"},{"Tenis"} };
	}
}
