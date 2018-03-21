package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.globant.automation.SeleniumUtils;

public class PedidosYaFoodPopUp extends PedidosYaRestaurantSelectionPage {

	public PedidosYaFoodPopUp(WebDriver d) {
		super(d);
		PageFactory.initElements(driver, this);
	}

	private WebElement menuPopUp;

	public String obtenerPrecio() {
		menuPopUp = SeleniumUtils.waitUntilClickable(By.className("menuModal"), driver);
		return menuPopUp.findElement(By.className("price")).getText();
	}

	public PedidosYaFoodSelectionPage agregarPedido() {
		menuPopUp = SeleniumUtils.waitUntilClickable(By.className("menuModal"), driver);
		menuPopUp.findElement(By.className("button")).click();
		return new PedidosYaFoodSelectionPage(driver);
	}

}
