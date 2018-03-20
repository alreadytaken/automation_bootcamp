package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.globant.automation.SeleniumUtils;

public class PedidosYaPopUpMapa extends PedidosYaMainPage {

	public PedidosYaPopUpMapa(WebDriver d) {
		super(d);
		PageFactory.initElements(driver, this);
		btnConfirmar = SeleniumUtils.waitUntilClickable(By.id("confirm"), driver);
	}

	//@FindBy(how = How.ID, using = "confirm")
	private WebElement btnConfirmar;

	public PedidosYaRestaurantSelectionPage confirmarUbicacion() {
		btnConfirmar.click();
		return new PedidosYaRestaurantSelectionPage(driver);
	}

}
