package test.pedidos.ya;

import java.net.MalformedURLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

/*
Direccion : Nicaragua 1666
Comida : milanesa
Producto Milanesa Completa Con papa fritas
*/


public class TestRealizarPedido {
	
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
    public void realizarCompra() {
    	
    	driver.get("http://pedidosya.com");
    	PedidosYaHomePage homePedidosYa = new PedidosYaHomePage(driver);
    }
    
    @AfterMethod
    public void cleanup() {
        driver.quit();
    }

}
