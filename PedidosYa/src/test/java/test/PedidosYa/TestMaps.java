package test.PedidosYa;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
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
    	
    	Map<String, Bandera> mapaDeBanderas =  new HashMap<String, Bandera>();
    	    	
    	driver.manage().window().maximize();
    	driver.get("http://pedidosya.com");
    	String arg = driver.findElement(By.xpath("//a[@id='linkAr']/i")).getText();
    	String url =  driver.findElement(By.id("linkAr")).getAttribute("host");
    	LOG.info(arg);
    	LOG.info(url);
       	Bandera argentinaFlag = new Bandera(driver.findElement(By.xpath("//a[@id='linkAr']/i")).getText(), driver.findElement(By.id("linkAr")).getAttribute("host"));
       	LOG.info("Llegueeee");
       	Bandera brasilFlag = new Bandera(driver.findElement(By.xpath("//a[@id='linkBr]/i")).getText(), brasil.getAttribute("host"));
       	LOG.info("Llegueeee");
       	Bandera chileFlag = new Bandera(driver.findElement(By.xpath("//a[@id='linkCl']/i")).getText(), chile.getAttribute("host"));
       	LOG.info("Llegueeee");
       	Bandera costaRica = new Bandera(driver.findElement(By.xpath("//a[@id='linkCr']/i")).getText(), ticos.getAttribute("host"));
       	LOG.info("Llegueeee");
       	Bandera panamaFlag = new Bandera(driver.findElement(By.xpath("//a[@id='linkPa']/i")).getText(), panama.getAttribute("host"));
       	LOG.info("Llegueeee");
       	Bandera paraguayFlag = new Bandera(driver.findElement(By.xpath("//a[@id='linkPy']/i")).getText(), paraguay.getAttribute("host"));
       	LOG.info("Llegueeee");
       	Bandera uruguayFlag = new Bandera(driver.findElement(By.xpath("//a[@id='linkUy']/i")).getText(), uruguay.getAttribute("host"));
       	
       	LOG.info("Llegueeee");
       	mapaDeBanderas.put("Argentina", argentinaFlag);
       	mapaDeBanderas.put("Brasil", brasilFlag);
       	mapaDeBanderas.put("Chile", chileFlag);
       	mapaDeBanderas.put("Costa Rica", costaRica);
       	mapaDeBanderas.put("Panama", panamaFlag);
       	mapaDeBanderas.put("Paraguay", paraguayFlag);
       	mapaDeBanderas.put("Uruguay", uruguayFlag);
       	
       	Iterator it = mapaDeBanderas.keySet().iterator();
       	for(String k:mapaDeBanderas.keySet()) {
       		mapaDeBanderas.get(k);
       	}
       	while(it.hasNext()) {
       		
       		Map.Entry<String, Bandera> e = (Entry) it.next(); 
       		
       		LOG.info(e.getKey() + e.getValue().getUrl());
       	}

    }
    
    @AfterMethod
    public void cleanup() {
        driver.quit();
    }

}
