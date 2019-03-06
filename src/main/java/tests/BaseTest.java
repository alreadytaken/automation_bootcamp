package tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
    
    protected static final Logger LOG;
    protected WebDriver driver;
    static {
        LOG = LogManager.getLogger(BaseTest.class);
    }

    @BeforeClass
    public void setUpClass() {
        LOG.info("Asegurando la instalacion de ChromeDriver");
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setUp() {
        LOG.info("Inicializando driver");
        ChromeOptions opts = new ChromeOptions();
        opts.addArguments("--incognit");
        opts.addArguments("--start-maximized");
        opts.addArguments("--test-type");
        opts.addArguments("--no-sandbox");
        driver = new ChromeDriver(opts);
        driver.get("https://www.linkedin.com.uy");
    }

    @AfterMethod
    public void tearDown() {
        LOG.info("Finalizando el test");
        driver.quit();
    }
}
