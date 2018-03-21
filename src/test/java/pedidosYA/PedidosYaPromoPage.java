package pedidosYA;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.globant.automation.SeleniumUtils;

public class PedidosYaPromoPage {
	// content_info
	private WebDriver driver;

	public PedidosYaPromoPage(WebDriver driver) {
		this.driver = driver;
		SeleniumUtils.waitUntilPresent(By.className("content_info"), driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.CLASS_NAME, using = "content_info")
	private WebElement promoEnter;

	public void promoEnter(WebDriver driver) {
		promoEnter.click();
	}
}