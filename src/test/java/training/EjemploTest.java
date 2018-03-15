package training;


import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EjemploTest {
	
	
	
	private WebDriver driver;
	
	
	private static final Logger LOG=LogManager.getLogger(EjemploTest.class);
	
    @Test
	public void prueba() {
	LOG.info("test de login");
	
	WebElement userfield = driver.findElement(By.name("userName"));
	WebElement passfield = driver.findElement(By.name("password"));
	WebElement btnlogin  = driver.findElement(By.name("login"));
	userfield.click();
	userfield.sendKeys("pruebaUsuario");
	passfield.click();
	passfield.sendKeys("pruebaPassword");
	btnlogin.click();
	;
    }
    @Test
    public void pruebast() {
	LOG.info("test de registro");
	
	driver.findElement(By.xpath("/html/body/div[1]/table/tbody/tr/td[2]/table/tbody/tr[2]/td/table/tbody/tr/td[2]/a")).click();
	WebElement fname  = driver.findElement(By.name("firstName"));
	WebElement lname  = driver.findElement(By.name("lastName"));
	WebElement phone  = driver.findElement(By.name("phone"));
	WebElement email  = driver.findElement(By.name("userName"));
	WebElement address1  = driver.findElement(By.name("address1"));
	WebElement address2  = driver.findElement(By.name("address2"));
	WebElement city  = driver.findElement(By.name("city"));
	WebElement state  = driver.findElement(By.name("state"));
	WebElement pcode  = driver.findElement(By.name("postalCode"));
	WebElement country  = driver.findElement(By.name("country"));
	WebElement uname  = driver.findElement(By.name("email"));
	WebElement pass  = driver.findElement(By.name("password"));
	WebElement cpass  = driver.findElement(By.name("confirmPassword"));
	WebElement btnreg  = driver.findElement(By.name("register"));
	fname.click();
	fname.sendKeys("Sebastian");
	lname.click();
	lname.sendKeys("Rodriguez");
	phone.click();
	phone.sendKeys("098987987");
	email.click();
	email.sendKeys("sebastianrodriguezpaiva@gmail.com");
	address1.click();
	address1.sendKeys("ejido 1122");
	address2.click();
	address2.sendKeys("yaguaron 2233");
	city.click();
	city.sendKeys("Montevideo");
	state.click();
	state.sendKeys("Montevideo");
	pcode.click();
	pcode.sendKeys("11100");
	country.click();
	uname.click();
	uname.sendKeys("srodriguez47");
	pass.click();
	pass.sendKeys("prueba123");
	cpass.click();
	cpass.sendKeys("prueba123");
	btnreg.click();

	
    }
    
    
    @BeforeMethod
    public void pruebabt() {
	LOG.info("Abre navegador");
	driver=new ChromeDriver();
	driver.manage().window().maximize();

	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	driver.get("http://www.newtours.demoaut.com");
	
		
		}	
    
 
    @AfterMethod
	public void pruebaat() {
	LOG.info("Cerrando navegador");	
	driver.quit();
	}
    @BeforeClass
    public void pruebabc() {
	LOG.info("Instalando el driver");
	WebDriverManager.chromedriver().setup();				
}
    @AfterClass
    public void pruebaac() {
	LOG.info("Metodo After class");		
}
   
    
    
    @DataProvider(name="Authentication")
    public Object[][] provider(){
    	return new Object [][] {{ "testuser_1", "Test@123","Juan" },{ "testuser_1", "Test@123","Pedro"}};
    	    	
    }
    @Test (dataProvider="Authentication")
    public void test(String sUsername, String sPassword,String sNombre) {
    	LOG.info(sUsername);
    	LOG.info(sPassword);
        LOG.info(sNombre);
    	Assert.assertEquals(sPassword, sPassword,"Usuario y contraseña");
    	Assert.assertEquals(sUsername, sUsername,"Usuario repetido");
    	
    }
    
    
    
}
