package PedidosYa;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PedidosYaBuyPage {
	private WebDriver driver;
	
	public PedidosYaBuyPage(WebDriver driver){
		this.driver = driver;
		
		PageFactory.initElements(driver, this);
	}
}
