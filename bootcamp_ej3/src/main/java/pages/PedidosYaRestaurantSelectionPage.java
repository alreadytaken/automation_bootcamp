package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.globant.automation.SeleniumUtils;

public class PedidosYaRestaurantSelectionPage extends PedidosYaMainPage {

	public PedidosYaRestaurantSelectionPage(WebDriver d) {
		super(d);
		PageFactory.initElements(driver, this);
		promo = SeleniumUtils.waitUntilClickable(By.xpath("//span[@class='promo']"), driver);
	}

	// @FindBy(how = How.CSS, using = "span[class='promo']")
	private WebElement promo; // = SeleniumUtils.waitUntilClickable(By.xpath("//span[@class='promo']"),
								// driver);

	public PedidosYaFoodPopUp clickPromo() {
		promo.click();
		return new PedidosYaFoodPopUp(driver);
	}
}
