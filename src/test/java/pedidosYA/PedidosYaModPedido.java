package pedidosYA;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class PedidosYaModPedido {
	//// *[@id="cart"]/header/div/a

	private WebDriver driver;

	public PedidosYaModPedido(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.XPATH, using = "// *[@id=\"cart\"]/header/div/")
	private WebElement modPedido;
	
	public void modPedido() {
		modPedido.click();
	}
}
