package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.globant.automation.SeleniumUtils;

public class PedidosYaCountryPage {
	public PedidosYaCountryPage(WebDriver driver) {
		SeleniumUtils.waitUntilVisible(By.cssSelector("div[class='flag-sprite uruguay']"), driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "div[class='flag-sprite uruguay']")
	WebElement uruguay;

	public PedidosYaHome navigateToUruguay(WebDriver driver){
		uruguay.click();
		return new PedidosYaHome(driver);
	}
}
