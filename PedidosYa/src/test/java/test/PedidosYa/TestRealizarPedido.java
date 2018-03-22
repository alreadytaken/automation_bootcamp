package test.PedidosYa;

import java.awt.AWTException;
import java.net.MalformedURLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;


public class TestRealizarPedido {
	
	private static final String userName = "Ejemplo";
	private static final String email = "miEjemploGlobant@gmail.com";
	private static final String password = "kesmaneskesman";
	private static final String address = "Nicaragua 1666";
	private static final String food = "Milanesa";
	private static final Logger LOG;
    private WebDriver driver;
    
    static {
        LOG = LogManager.getLogger(TestRealizarPedido.class);
    }
    
    public static String getFood() {
		return food;
	}

	public static String getAddress() {
		return address;
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
    public void realizarCompra() throws InterruptedException, AWTException {

    	driver.manage().window().maximize();
    	driver.get("http://pedidosya.com");

    	PedidosYaHomePage homePedidosYa = new PedidosYaHomePage(driver);
    	PedidosYaHomeUruguay homeUruguay = homePedidosYa.pedidosYaUruguay();
    	homeUruguay.realizeSearch(address, food);
    	SugerenciasPedidosYa sugerenciasPage = homeUruguay.confirmaAddress();
    	

    	String priceSuggested = sugerenciasPage.getPrice();

    	DescripcionDeSugerencia descripcionPage = sugerenciasPage.seleccionarSugerencia();
    	descripcionPage.agregarPedido();

    	String finalPrice = descripcionPage.getTotalPrice();
    	String finalAddress = descripcionPage.getAddress();

    	LoginPedidosYa login = descripcionPage.confirmarCompra();
    	
    	Assert.assertEquals(priceSuggested, finalPrice);
    	Assert.assertEquals(getAddress(), finalAddress);
    	
    	UsuarioLogueadoFinalizarPedido loggedUserPage = login.ingresarDatos(email, password);
    	ChequearUserNamePage finalPage = loggedUserPage.modificarMiPedido();
    	String usuarioEnPantalla = finalPage.getNombre();

    	Assert.assertEquals(userName, usuarioEnPantalla);
    }
    
    @AfterMethod
    public void cleanup() {
        driver.quit();
    }

}