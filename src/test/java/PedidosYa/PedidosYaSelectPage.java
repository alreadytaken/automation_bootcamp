package PedidosYa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.globant.automation.SeleniumUtils;

public class PedidosYaSelectPage {
	private WebDriver driver;
	
	public PedidosYaSelectPage(WebDriver driver){
		this.driver = driver;
		
		if (!SeleniumUtils.isPresent(By.xpath("//span[@class=\"promo\"]"), driver)) {
			throw new IllegalStateException("Page did not load");
		}
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[@class=\"promo\"]")
	private WebElement promo;
	
	@FindBy(xpath="//span[@class='after_price']")
	private WebElement price;
	
	public PedidosYaConfirmPage selectPromo() {
		this.promo.click();
		return new PedidosYaConfirmPage(driver);
	}

	public String savePrice(String data) {
		data = price.getText();
		return data;
	}
}