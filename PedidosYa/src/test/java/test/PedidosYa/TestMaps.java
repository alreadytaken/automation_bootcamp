package test.PedidosYa;
import java.net.MalformedURLException;
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

	@FindBy(how = How.XPATH,using = "//ul[@class= 'flags']/li/a")
	private List<WebElement> banderas;
	
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
    	
    	Map<String, WebElement> mapaDeBanderas;
    	int tam = banderas.size();
       	Bandera argentina = new Bandera(banderas.get(0).getText(), banderas.get(0).getAttribute("host"));
       	Bandera brasil = new Bandera(banderas.get(1).getText(), banderas.get(0).getAttribute("host"));
       	Bandera chile = new Bandera(banderas.get(0).getText(), banderas.get(0).getAttribute("host"));
       	Bandera costaRica = new Bandera(banderas.get(0).getText(), banderas.get(0).getAttribute("host"));
       	Bandera panama = new Bandera(banderas.get(0).getText(), banderas.get(0).getAttribute("host"));
       	Bandera paraguay = new Bandera(banderas.get(0).getText(), banderas.get(0).getAttribute("host"));
       	Bandera uruguay = new Bandera(banderas.get(0).getText(), banderas.get(0).getAttribute("host"));
       	
       	Iterator it = mapaDeBanderas.keySet().iterator();

    }
    
    @AfterMethod
    public void cleanup() {
        driver.quit();
    }

}
