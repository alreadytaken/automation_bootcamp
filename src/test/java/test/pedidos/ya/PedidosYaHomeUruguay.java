package test.pedidos.ya;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import com.globant.automation.SeleniumUtils;

public class PedidosYaHomeUruguay {
	
	@FindBy(how = How.XPATH, using = "//input[@id = 'address']")
	private WebElement addressButton;

	@FindBy(how = How.XPATH, using ="//input[@id = 'optional']")
	private WebElement optionalButton;
	
	@FindBy(how = How.XPATH, using ="//button[@id = 'search']")
	private WebElement searchButton;
	
	@FindBy(how = How.XPATH, using ="//section[@id = 'mapModal']")
	private WebElement popUpMap;
	
	@FindBy(how = How.XPATH, using ="//a[@id = 'confirm']")
	private WebElement confirmAddressButton;

	private WebDriver driver;
	
	public PedidosYaHomeUruguay(WebDriver driver){

		this.driver = driver;				
		PageFactory.initElements(driver, this);
	}
	
	public void realizeSearch(String address, String food) {
		
		this.addressButton.sendKeys(address);
		this.optionalButton.sendKeys(food);		
		this.searchButton.click();
	}
	
	public SugerenciasPedidosYa confirmaAddress() {
		
		SeleniumUtils.waitUntilClickable(confirmAddressButton, driver);
		this.confirmAddressButton.click();
		return new SugerenciasPedidosYa(driver);
	}

}
