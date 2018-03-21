package TestPedidosYa;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.ElementNotVisibleException;
import org.testng.annotations.Test;

import Ejercicio2.MercadolibreTest;

public class PedidosYaTest extends FunctionalTest {
	
	private static final Logger LOG;
    

    static {
        LOG = LogManager.getLogger(MercadolibreTest.class);
    }
	
	
	@Test
	public void TestPedidosYa() throws  ElementNotVisibleException{
		LOG.info("Search test");
		String address = "Nicaragua 1666";
		String food = "milanesa";
		String precio = "";
        driver.get("https://pedidosya.com");
        PedidosYaHomePage page1 = new PedidosYaHomePage(driver);
        HomePageUruguay page2 = new HomePageUruguay(driver);
        SugerenciasPage page3 = new SugerenciasPage(driver);
        RestaurantePage page4 = new RestaurantePage(driver);
        page1.click();
        page2.inputaddress(address);
        page2.inputfood(food);
        page2.click();
        page3.click();
        page4.getprecio(precio);
        page4.click();
      
        

}
	
}
