package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class PedidosYaRestaurantSelectionPage extends PedidosYaMainPage{

	public PedidosYaRestaurantSelectionPage(WebDriver d) {
		super(d);
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.CSS, using = "span[class='promo']")
	private WebElement promo; // = SeleniumUtils.waitUntilClickable(By.xpath("//span[@class='promo']"), driver);
	
	public PedidosYaFoodSelectionPage clickPromo() {
		promo.click();
		return new PedidosYaFoodSelectionPage(driver);
	}
}
