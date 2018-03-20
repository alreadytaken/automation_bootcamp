package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PedidosYaRestaurantSelectionPage extends PedidosYaMainPage{

	public PedidosYaRestaurantSelectionPage(WebDriver d) {
		super(d);
	}

	@FindBy(how = How.CSS, using = "span[class='promo']")
	private WebElement promo;
	
	
}
