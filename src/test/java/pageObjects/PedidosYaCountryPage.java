package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.globant.automation.SeleniumUtils;

import Items.Bandera;

public class PedidosYaCountryPage {
	public PedidosYaCountryPage(WebDriver driver) {
		SeleniumUtils.waitUntilVisible(By.cssSelector("div[class='flag-sprite uruguay']"), driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "div[class='flag-sprite uruguay']")
	WebElement uruguay;
	
	@FindBy(css = ".flags li")
	List<WebElement> banderasElements;
	
	public Bandera getBandera(int index) {
		WebElement aux = banderasElements.get(index);
		return new Bandera(aux);
	}

	public PedidosYaHome navigateToUyHome(WebDriver driver){
		uruguay.click();
		return new PedidosYaHome(driver);
	}
}
