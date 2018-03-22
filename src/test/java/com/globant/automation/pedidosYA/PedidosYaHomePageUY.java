package pedidosYA;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.globant.automation.SeleniumUtils;

public class PedidosYaHomePageUY {
	// name "adress"
	// name "optional"
	// id search
	private WebDriver driver;

	public PedidosYaHomePageUY(WebDriver driver) {
		this.driver = driver;
		SeleniumUtils.waitUntilPresent(By.id("address"), driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(how = How.ID, using = "address")
	public WebElement addressTxt;

	@FindBy(how = How.ID, using = "optional")
	public WebElement foodTxt;

	@FindBy(how = How.ID, using = "search")
	public WebElement buttonSearch;

	public void enterInfo(String address, String food) {
		addressTxt.sendKeys(address);
		foodTxt.sendKeys(food);
		buttonSearch.click();
	}

	/*public PedidosYaConfirmPage navigateToConfirmPage(WebDriver driver) {
		
		return new PedidosYaConfirmPage(driver);
	}*/

}
