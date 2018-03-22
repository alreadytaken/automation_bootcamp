package pedidosYA;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.globant.automation.SeleniumUtils;

public class PedidosYaModPedido {
	//// *[@id="cart"]/header/div/a

	private WebDriver driver;

	public PedidosYaModPedido(WebDriver driver) {
		this.driver = driver;
		SeleniumUtils.waitUntilPresent(By.className("cart-subtitle"), driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.CLASS_NAME, using = "cart-subtitle")
	private WebElement modPedido;
	
	public void modPedido() {
		modPedido.click();
	}
}
