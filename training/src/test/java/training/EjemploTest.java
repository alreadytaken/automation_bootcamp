package training;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EjemploTest {
	private WebDriver driver; 
	private static final Logger LOG = LogManager.getLogger(EjemploTest.class);
	@Test(dataProvider = "Authentication")
	public void test1(String sUsername, String sPassword, String sResult )
{
		WebElement txtUserName = driver.findElement(By.name("userName"));
		Assert.assertFalse(sUsername == sPassword, "estoy comparando1");
		Assert.assertTrue(sUsername == sPassword , "estoy comparando2");
		
		
	}
	@DataProvider(name = "Authentication")
	public Object[][] provider()
	{
		return new Object[][] {{"testuser_1", "Test@123", "result"}, {"testuser_1", "Test@123", "result"}};
	}
	
	@BeforeMethod
	public void test2()
	{
		driver = new ChromeDriver();
	LOG.info("Before");
	}
	
	@AfterMethod
	public void test3()
	{
		LOG.info("After");
		driver.quit();
		//name="userName"
		//name="password"
		//name="login"
	}
	
	@AfterClass
	public void test4()
	{
		
	}
	
	@BeforeClass
	public void test5()
	{
		LOG.info("instalando driver");
		WebDriverManager.chromedriver().setup();
	}
	
}
