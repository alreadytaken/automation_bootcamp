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
		menuPopUp = SeleniumUtils.waitUntilClickable(By.className("menuModal"), driver);
	}

	// @FindBy (how = How.ID, using = "footerOpen")
	private WebElement menuPopUp;
	
	public String obtenerPrecio() {
		return menuPopUp.findElement(By.className("price")).getText();
	}

}
