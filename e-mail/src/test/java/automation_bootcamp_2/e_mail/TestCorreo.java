package automation_bootcamp_2.e_mail;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCorreo {

	WebDriver driver;
	
public TestCorreo() {
		
	}

private static final Logger LOG;
	
	static {
		LOG = LogManager.getLogger(TestCorreo.class);
	}
	
	
	




	@Test
	public void IngresarCorreo() {
		
		driver.get("https://accounts.google.com/ServiceLogin?service=mail&passive=true&rm=false&continue=https://mail.google.com/mail/&ss=1&scc=1&ltmpl=default&ltmplcache=2&emr=1&osid=1#");
		LoginPageGmail loginCorreo = new LoginPageGmail(driver);
		loginCorreo.ingresarCorreo();
		
		
		IngresarContraseñaPage login_page = loginCorreo.clickearBoton();
		
		PrincipalPage principal_page = login_page.ingresarPass();
		principal_page.ListaElementos();
		
	}
	
	
	
	
	@BeforeMethod
	public void prepareTest() {
		
		LOG.info("Preparing");
		
		ChromeOptions options = new ChromeOptions();
		
		options.addArguments("--incognito");
		options.addArguments("disable-infobars");
		driver = new ChromeDriver(options);
		
		
	}
	
	
	@AfterMethod
	public void cleanup() {
		driver.quit();
	}
		
	@BeforeClass
	private void prepareClass() {
		LOG.info("Preparing class");
		
		
		WebDriverManager.chromedriver().setup();
		
	}	
	
	
	
	
	
}//class
