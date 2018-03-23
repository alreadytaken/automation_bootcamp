package PedidosYa;

import javax.management.BadBinaryOpValueExpException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.globant.automation.SeleniumUtils;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TESTLOGIN {

	public static WebDriver driver;
	public static Logger LOG = LogManager.getLogger(TESTLOGIN.class);

	@BeforeMethod
	public void prepareTest() {
		LOG.info("Prepare test");
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

	/*
	 * @FindBy(id="linkUy") WebElement BanderaUruguay;
	 */

	/*
	 * @FindBy(id="lnkLogin") WebElement Ingresar;
	 */

	@Test
	public void normalTest() {

		String user = "MiEjemploGlobant@gmail.com";
		String pass = "kesmaneskesman";

		driver.get("http://www.pedidosya.com");
		driver.manage().window().maximize();

		WebElement BanderaUruguay = driver.findElement(By.id("linkUy"));
		SeleniumUtils.waitUntilClickables(By.id("linkUy"), driver);
		BanderaUruguay.click();

		WebElement Ingresar = driver.findElement(By.id("lnkLogin"));
		SeleniumUtils.waitUntilClickable(Ingresar, driver);
		Ingresar.click();

	
		SeleniumUtils.isVisible(By.xpath("//div/iframe"), driver);
		
		

		WebElement IFRAME = driver.findElement(By.xpath("//div/iframe"));
		driver.switchTo().frame(IFRAME);
		
		SeleniumUtils.waitUntilClickables(By.xpath("//input[@name='email']"), driver);
		WebElement email = driver.findElement(By.xpath("//input[@name='email']"));
		
		email.sendKeys("funciona");
		
		WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
		password.sendKeys("fua");

		
	}

}
