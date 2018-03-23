package TestPedidosYa;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.ElementNotVisibleException;
import org.testng.Assert;
import org.testng.annotations.Test;



public class PedidosYaTest extends FunctionalTest {
	
	private static final Logger LOG;
    

    static {
        LOG = LogManager.getLogger(PedidosYaTest.class);
    }
	
	
	@Test
	public void TestPedidosYa() throws  ElementNotVisibleException{
		LOG.info("Search test");
		String address = "Nicaragua 1666";
		String food = "milanesa";
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
        String preciopopup = page4.getpreciopopup().getText();
        page4.click();
        String preciofinal = page4.getpreciofinal().getText();
        String addressfinal = "Delivery para" + page4.getaddress().getText();
        
        Assert.assertEquals(addressfinal, address, "estoy comparando la direccion ingresada con la mostrada al final");
        Assert.assertEquals(preciopopup, preciofinal, "estoy comparando el precio mostrado al principio con el final");
      
        

}
	
}
