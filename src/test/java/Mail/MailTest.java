package Mail;

import java.net.MalformedURLException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import PedidosYa.PedidosYaTestPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class MailTest {

	private WebDriver driver;

	private static final Logger LOG;

	static {
		LOG = LogManager.getLogger(MailTest.class);
	}

	@BeforeMethod
	public void prepareTest() throws MalformedURLException {
		LOG.info("Prepare test");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-infobars", "--incognito");

		driver = new ChromeDriver(options);
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

	@Test
	public void normalTest() {
		driver.get("http://www.gmail.com");

		String user = "testingglobant666@gmail.com";
		String pass = "prueba1234";
		
		List<String> mails;
		
		

		MailLoginUser mUser = new MailLoginUser(driver);
		MailLoginPass mPass;
		MailHome mHome;
		
		mPass = mUser.typeUser(user);
		mHome = mPass.typePass(pass);
		mails = mHome.getSubject();
			
		for (int i = 0; i < mails.size(); i++) {
			LOG.info(mails.get(i));
		}

	}

}
