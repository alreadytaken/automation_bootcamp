package pedidosYa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.globant.automation.SeleniumUtils;

public class PedidosYaPromoPage {
	// id confirm
	//https://staging.pedidosya.com
		private WebDriver driver;
		public PedidosYaPromoPage(WebDriver driver) {
			this.driver = driver;
			SeleniumUtils.waitUntilPresent(By.xpath("[@class=button"/a");"
			PageFactory.initElements(driver, this);
		}
		
		@FindBy(how = How.ID, using = "confirm")
		private WebElement confirmButton;
}
