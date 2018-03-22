package com.globant.automation;

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
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

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
        driver.get("https://google.com");
        WebDriverWait w = new WebDriverWait(driver,10);
        WebElement e = w.until(ExpectedConditions.elementToBeClickable(By.name("q")));
        WebElement txtIngreso1 = driver.findElement(By.name("q"));
        txtIngreso1.sendKeys("hola");
    	txtIngreso1.sendKeys(Keys.ENTER);
    	
        LOG.info("Prepare test");
    }
    @Test
    public void searchTest2() throws InterruptedException {
        LOG.info("Search test2");
        List<WebElement> resultados = new ArrayList<>();
        List<String> google = new ArrayList<>();
        List <String> bing = new ArrayList<>();
        driver.get("https://google.com");
        WebDriverWait w = new WebDriverWait(driver,10);
        WebElement e = w.until(ExpectedConditions.elementToBeClickable(By.name("q")));
        WebElement txtIngreso1 = driver.findElement(By.name("q"));
        txtIngreso1.sendKeys("hola");
    	txtIngreso1.sendKeys(Keys.ENTER);
    	resultados = driver.findElements(By.xpath("//h3[@class='r']/a"));
    	for (int i =0;i<5;i++) {
    		google.add(resultados.get(i).getText());
    	}
    	driver.get("http://bing.com");
    	WebDriverWait x = new WebDriverWait(driver,10);
        WebElement E = x.until(ExpectedConditions.elementToBeClickable(By.name("q")));
        WebElement txtIngreso2 = driver.findElement(By.name("q"));
        txtIngreso2.sendKeys("hola");
        txtIngreso2.sendKeys(Keys.ENTER);
    	resultados = driver.findElements(By.xpath("//h2/a"));
    	for (int i =0;i<5;i++) {
    		bing.add(resultados.get(i).getText());
    	}
    	for (int i=0;i<5;i++) {
    		Assert.assertEquals(google.get(i), bing.get(i));
    	}
    	
        LOG.info("Prepare test");
    }
    @Test
    public void pedidosYaTest() throws InterruptedException {
        LOG.info("Pedidos Ya Test");
        //List<WebElement> resultados = new ArrayList<>();
        //List<String> google = new ArrayList<>();
        //List <String> bing = new ArrayList<>();
        driver.get("http://www.pedidosya.com");
        WebDriverWait a = new WebDriverWait(driver,10);
        WebElement b = a.until(ExpectedConditions.elementToBeClickable(By.id("linkUy")));
        WebElement btnUruguay = driver.findElement(By.id("linkUy"));
        btnUruguay.submit();
        WebDriverWait c = new WebDriverWait(driver,10);
        WebElement WE = c.until(ExpectedConditions.elementToBeClickable(By.id("adress")));
        WebElement imputDire = driver.findElement(By.id("adress"));
        imputDire.sendKeys("Nicaragua 1666");
        WebElement imputComida = driver.findElement(By.id("optional"));
        imputComida.sendKeys("milanesa");
        WebElement btnBuscar = driver.findElement(By.id("search"));
        btnBuscar.submit();
    	/*resultados = driver.findElements(By.xpath("//h3[@class='r']/a"));
    	for (int i =0;i<5;i++) {
    		google.add(resultados.get(i).getText());
    	}
    	driver.get("http://bing.com");
    	WebDriverWait x = new WebDriverWait(driver,10);
        WebElement E = x.until(ExpectedConditions.elementToBeClickable(By.name("q")));
        WebElement txtIngreso2 = driver.findElement(By.name("q"));
        txtIngreso2.sendKeys("hola");
        txtIngreso2.sendKeys(Keys.ENTER);
    	resultados = driver.findElements(By.xpath("//h2/a"));
    	for (int i =0;i<5;i++) {
    		bing.add(resultados.get(i).getText());
    	}
    	for (int i=0;i<5;i++) {
    		Assert.assertEquals(google.get(i), bing.get(i));
    	}
    	
        LOG.info("Prepare test");*/
    }
    @BeforeMethod
    public void prepareTest() throws MalformedURLException {
    	
        driver = new ChromeDriver();
        /*DesiredCapabilities caps = DesiredCapabilities.firefox();
        driver = new RemoteWebDriver(new URL("http://127.0.0.1:4444/wd/hub"), caps);*/
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
}
