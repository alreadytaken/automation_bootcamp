package training;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


public class EjemploTest {

	private WebDriver driver;
	 //name="userName" 
	//name="password"
	//name="login" (sign-in) 
	
	
	
private static final Logger LOG = LogManager.getLogger(EjemploTest.class);

	@Test
	public void coso() {
			
		LOG.info("test");
	}
	
	@BeforeMethod
	public void coso2() {
		LOG.info("beforeTest");
		driver = new FirefoxDriver(); //Crea una instancia del navegador
	}
	
	@AfterMethod
	public void coso3() {
		LOG.info("aftertest");
		driver.quit(); //Cierro el navegador
	}

	@Test
	public void coso4() {
		LOG.info("test");
		WebElement txtUsername = driver.findElement(By.id("userName"));
		txtUsername.click();
		txtUsername.sendKeys("Pedro");
	}
@BeforeClass
	public void coso5() {
	LOG.info("test beforeClass");
	
	LOG.info("Instalando driver");
	WebDriverManager.firefoxdriver().setup(); //asegura que tengo el driver de ff corriendo
	

	
	}
	@AfterClass
	public void coso6() {
		LOG.info("test afterclass");
}
@DataProvider(name= "Authentication")
	public Object[][] provider(){
		
		return new Object[][] {{"Juan", "Pedro"},{"testuser_1", "Test@123"}, {"testuser_1", "Test@123"}, {"Juan", "Pedro"}};
	}
	@Test(dataProvider = "Authentication")
public void test(String sUsername, String sPassword) {
		LOG.info(sUsername);
		LOG.info(sPassword);
		LOG.info("");
	
}
	@Test(dataProvider = "Authentication")
	public void test2(String user, String pass) {
		String user1 = "Juan";
		String pass1 = "Pedro";
		
		Assert.assertTrue((user == user1 && pass == pass1 ), "caso true");
		Assert.assertFalse((user == user1 && pass == pass1 ), "caso false");
		
	}
	
	
	public static void main(String[] args) {
		
	}
	

}
