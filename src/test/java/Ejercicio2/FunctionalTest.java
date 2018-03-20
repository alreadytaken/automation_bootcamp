package Ejercicio2;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FunctionalTest {
	protected static WebDriver driver;

	@BeforeClass
	public static void setUp(){
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@AfterMethod
    public void cleanUp(){
        driver.manage().deleteAllCookies();
    }
	
	@AfterClass
    public static void tearDown(){
		 driver.close();
    }   
	}
