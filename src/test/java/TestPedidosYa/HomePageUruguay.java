package TestPedidosYa;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.globant.automation.SeleniumUtils;

public class HomePageUruguay extends PageObject {
	
	@FindBy(how = How.XPATH, using = "//input[@id='address']")
	private WebElement AddressTextBox;
	
	@FindBy(how = How.XPATH, using = "//input[@name='optional']")
	private WebElement ComidaTextBox;
	
	@FindBy(how = How.ID, using = "search")
	private WebElement SearchButton;
	
	@FindBy(how = How.ID, using = "confirm")
	private WebElement ConfirmButton;
	
	public HomePageUruguay (WebDriver driver) {
	    super(driver);
	}
	
	public void inputaddress (String input) {
		WebElement AddressTextBox = SeleniumUtils.waitUntilClickable(By.xpath("//input[@id='address']"), driver);
		AddressTextBox.sendKeys(input);
		AddressTextBox.sendKeys(Keys.ENTER);
	}
	
	public void inputfood (String input) {
		WebElement ComidaTextBox = SeleniumUtils.waitUntilClickable(By.xpath("//input[@name='optional']"), driver);
		ComidaTextBox.sendKeys(input);
		ComidaTextBox.sendKeys(Keys.ENTER);
	}
	
	public SugerenciasPage click() {
		SearchButton.click();
		WebElement ConfirmButton = SeleniumUtils.waitUntilClickable(By.id("confirm"), driver);
		ConfirmButton.click();
		return new SugerenciasPage(driver);
		
	}
	
			
	

}
