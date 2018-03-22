package pedidosYA;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.globant.automation.SeleniumUtils;

public class PedidosYaFoodPage {
	private WebDriver driver;
	//id order
	public PedidosYaFoodPage(WebDriver driver) {
		this.driver = driver;
		SeleniumUtils.waitUntilPresent(By.id("order"), driver);
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(how = How.ID, using = "order")
	private WebElement confirmPedido;
	
	public void confirmPedido(WebDriver driver) {
		SeleniumUtils.waitUntilPresent(By.id("order"), driver);
		confirmPedido.click();
	}
}
