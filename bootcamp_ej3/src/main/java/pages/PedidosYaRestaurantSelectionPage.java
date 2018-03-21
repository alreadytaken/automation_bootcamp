package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.globant.automation.SeleniumUtils;

public class PedidosYaRestaurantSelectionPage extends PedidosYaMainPage {

	public PedidosYaRestaurantSelectionPage(WebDriver d) {
		super(d);
		PageFactory.initElements(driver, this);

	}

	private WebElement promo;

	public PedidosYaFoodPopUp clickPromo() {
		promo = SeleniumUtils.waitUntilClickable(By.xpath("//span[@class='promo']"), driver);
		// Codigo de emergencia
		List<WebElement> lista = driver.findElements(By.xpath("//span[@class='promo']"));
		if (promo.getText().equals("Milanesa completa al pan con papas fritas")) {
			promo = lista.get(1);
		}
		// Hasta acá
		promo.click();
		return new PedidosYaFoodPopUp(driver);
	}
}
