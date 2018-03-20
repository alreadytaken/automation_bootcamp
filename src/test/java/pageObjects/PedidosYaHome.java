package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.globant.automation.SeleniumUtils;

public class PedidosYaHome {
	protected WebDriver driver;

	public PedidosYaHome(WebDriver driver) {
		this.driver = driver;
		SeleniumUtils.waitUntilClickable(By.cssSelector("fieldset.row a.chosen-single"), driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="input#address.primary")
	WebElement addressInput;
	
	@FindBy(css="input#optional.secondary")
	WebElement foodInput;
	
	@FindBy(css="button#search")
	WebElement searchButton;
	
	public void fillForm(String address, String foodtype) {
		addressInput.sendKeys(address);
		foodInput.sendKeys(foodtype);
	}
	
	public void navigateToConfirmLocation(WebDriver driver) {
		searchButton.click();
	}

}
