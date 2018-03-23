package test.PedidosYa;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import com.globant.automation.SeleniumUtils;

public class PedidosYaHomeUruguay {
	
	@FindBy(how = How.ID, using = "address")
	private WebElement addressButton;

	@FindBy(how = How.ID, using ="optional")
	private WebElement optionalButton;
	
	@FindBy(how = How.ID, using ="search")
	private WebElement searchButton;
	
	@FindBy(how = How.ID, using ="mapModal")
	private WebElement popUpMap;
	
	@FindBy(how = How.ID, using ="confirm")
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