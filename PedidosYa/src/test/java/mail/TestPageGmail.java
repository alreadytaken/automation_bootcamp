package mail;

import java.net.MalformedURLException;
import java.util.List;

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
import test.PedidosYa.TestRealizarPedido;

public class TestPageGmail {
	
	private static final String email = "miEjemploGlobant@gmail.com";
	private static final String password = "kesmaneskesman";
	private static final String sendTo = "carlos.cadena@globant.com; gabriel.caamano@globant.com";
	private static final String subject = "No soy un SPAM";
	private static final String body = "Tomá un regalito";
	private static final Logger LOG;
	private WebDriver driver;
    
    static {
        LOG = LogManager.getLogger(TestRealizarPedido.class);
    }

    @BeforeClass
    private void prepareClass() {
        LOG.info("Prepare class");
        WebDriverManager.chromedriver().setup();
    }
    
    @BeforeMethod
    public void prepareTest() throws MalformedURLException {
    	ChromeOptions options = new ChromeOptions();
    	options.addArguments("--incognito");
        
    	driver = new ChromeDriver(options);
   }
    
	@Test
	public void subjectList() {
		
		driver.manage().window().maximize();
    	driver.get("http://gmail.com");
    	gmailPage gmailHome = new gmailPage(driver);
    	WelcomePage enterPasswordPage = gmailHome.enterEmail(email);
    	LoggedUser loggedUserPage = enterPasswordPage.enterPassword(password);
    	List<String> oddList = loggedUserPage.getOddSubjects();
    	int tam = oddList.size();
    	for(int i=0; i<tam; i++) {
    		LOG.info(oddList.get(i));
    	}
	}
	
    @AfterMethod
    public void cleanup() {
        driver.quit();
    }


}
