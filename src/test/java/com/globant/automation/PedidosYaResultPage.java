package pedidosYa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.globant.automation.SeleniumUtils;

public class PedidosYaResultPage {
// class="content_info"
	private WebDriver driver;
	public PedidosYaResultPage(WebDriver driver) {
		this.driver = driver;
		SeleniumUtils.waitUntilPresent(By.xpath("[@class="peyaCard_js-fp-card"]/span"), driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.XPATH, using = "[@class=\"peyaCard js-fp-card\"]/span")
	private WebElement confirmButton;
}
