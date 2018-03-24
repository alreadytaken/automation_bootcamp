package com.globant.automation;
import java.net.MalformedURLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.globant.automation.util.amazonHome;
import com.globant.automation.util.lentes;
import com.globant.automation.util.topComentarios;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonTest {
	
	public AmazonTest() {

    }

    private static final Logger LOG;
    private WebDriver driver;

    static {
        LOG = LogManager.getLogger(AmazonTest.class);
}
    @Test
    public void pedidosYaTest() throws InterruptedException {
		driver.get("http://www.amazon.com");
		amazonHome POHome = new amazonHome(driver);
		lentes POlentes = POHome.buscarProductoLentes();
		topComentarios POTopComentarios = POlentes.bucarComentarios();
		/*restaurantes POrestaurantes = POpopUpDireccion.irATodosLosRestaurantesApretandoBoton();
		popUpComida POpopUpComida = POrestaurantes.selecionarComida();
		restoQueVoyAPedir POrestoQueVoyAPedir = POpopUpComida.agregarAMiPedido();
		popUpRegistro POpopUpRegistro = POrestoQueVoyAPedir.agregarAMiPedido();*/
		
    }
	@BeforeMethod
    public void prepareTest() throws MalformedURLException {
    	
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


}
