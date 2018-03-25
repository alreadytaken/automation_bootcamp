package com.globant.automation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
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

    @Test
    public void testExamen() {
        driver.get("https://amazon.com");
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
