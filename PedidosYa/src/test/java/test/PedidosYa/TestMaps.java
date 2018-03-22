package test.PedidosYa;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestMaps {

	@FindBy(how = How.ID, using = "linkAr")
	private WebElement argentina;

	@FindBy(how = How.ID, using = "linkBr")
	private WebElement brasil;
	
	@FindBy(how = How.ID, using = "linkCl")
	private WebElement chile;
	
	@FindBy(how = How.ID, using = "linkCr")
	private WebElement ticos;
	
	@FindBy(how = How.ID, using = "linkPa")
	private WebElement panama;
	
	@FindBy(how = How.ID, using = "linkPy")
	private WebElement paraguay;
	
	@FindBy(how = How.ID, using = "linkUy")
	private WebElement uruguay;
	
	
	
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
    	
        driver = new ChromeDriver();
   }

    @Test
    public void guardarBanderasEnMapa() {
    	
    	Map<String, WebElement> mapaDeBanderas =  new HashMap<String, WebElement>();
    	    	
       	Bandera argentinaFlag = new Bandera(argentina.getText(), argentina.getAttribute("host"));
       	Bandera brasilFlag = new Bandera(brasil.getText(), brasil.getAttribute("host"));
       	Bandera chileFlag = new Bandera(chile.getText(), chile.getAttribute("host"));
       	Bandera costaRica = new Bandera(ticos.getText(), ticos.getAttribute("host"));
       	Bandera panamaFlag = new Bandera(panama.getText(), panama.getAttribute("host"));
       	Bandera paraguayFlag = new Bandera(paraguay.getText(), paraguay.getAttribute("host"));
       	Bandera uruguayFlag = new Bandera(uruguay.getText(), uruguay.getAttribute("host"));
       	
       	Iterator it = mapaDeBanderas.keySet().iterator();

    }
    
    @AfterMethod
    public void cleanup() {
        driver.quit();
    }

}
