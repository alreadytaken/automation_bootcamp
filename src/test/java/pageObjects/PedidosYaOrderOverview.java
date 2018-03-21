package pageObjects;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.globant.automation.SeleniumUtils;

public class PedidosYaOrderOverview {
	protected WebDriver driver;
	
	public PedidosYaOrderOverview(WebDriver driver) {
		this.driver = driver;
		SeleniumUtils.waitUntilClickable(By.cssSelector("#order"), driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "#deliveryType span")
	WebElement address;
	
	@FindBy(css = "div[class='price total-price']")
	WebElement priceTotal;
	
	@FindBy(css = "#order")
	WebElement orderButton;
	
	@FindBy(css = "#lnkUserName div[class='left top-link']")
	WebElement loginName;

	public String getAddress() {
		
		String aux = address.getText();
		aux = StringUtils.remove(aux, "Delivery para ");
		return aux;
	}
	
	public String getPrice() {
		return priceTotal.getText();
	}
	
	public String getLoginName() {
		return loginName.getText();
	}
	
	public PedidosYaSignInForm navigateToSignInForm() {
		orderButton.click();
		return new PedidosYaSignInForm(driver);
	}
}
