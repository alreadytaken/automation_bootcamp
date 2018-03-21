package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.globant.automation.SeleniumUtils;

public class PedidosYaPopUpMapa extends PedidosYaMainPage {

	public PedidosYaPopUpMapa(WebDriver d) {
		super(d);
		PageFactory.initElements(driver, this);
	}

	private WebElement btnConfirmar;

	public PedidosYaRestaurantSelectionPage confirmarUbicacion() {
		SeleniumUtils.waitUntilClickable(By.id("searchMap"), driver);
		SeleniumUtils.waitUntilVisible(By.xpath("//div[@class='gmnoprint']"), driver);
		btnConfirmar = SeleniumUtils.waitUntilClickable(By.id("confirm"), driver);
		btnConfirmar.click();
		return new PedidosYaRestaurantSelectionPage(driver);
	}

}
