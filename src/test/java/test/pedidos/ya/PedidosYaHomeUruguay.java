package test.pedidos.ya;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PedidosYaHomeUruguay {
	
	private WebDriver driver;
	public PedidosYaHomeUruguay(WebDriver driver){

		this.driver = driver;				
		PageFactory.initElements(driver, this);

	}

}
