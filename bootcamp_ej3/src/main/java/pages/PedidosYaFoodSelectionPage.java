package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.globant.automation.SeleniumUtils;

public class PedidosYaFoodSelectionPage extends PedidosYaRestaurantSelectionPage {

	public PedidosYaFoodSelectionPage(WebDriver d) {
		super(d);
		PageFactory.initElements(driver, this);
	}

	private WebElement datosPedido;
	private WebElement btnContinuar;

	public String[] obtenerDatos() {
		datosPedido = SeleniumUtils.waitUntilClickable(By.id("scrollContent"), driver);
		SeleniumUtils.waitUntilVisible(By.id("deliveryType"), driver);
		String[] ret = new String[2];
		ret[0] = datosPedido.findElement(By.className("data")).getText();
		ret[1] = datosPedido.findElement(By.className("price")).getText();
		return ret;
	}

	public PedidosYaPopUpLogIn clickContinuar() {
		btnContinuar = SeleniumUtils.waitUntilClickable(By.id("order"), driver);
		btnContinuar.click();
		return new PedidosYaPopUpLogIn(driver);
	}
	
	public PedidosYaPopUpLogIn clickLogIn() {
		WebElement btnLogIn = driver.findElement(By.id("lnkLogin"));
		btnLogIn.click();
		return new PedidosYaPopUpLogIn(driver);
	}
}
