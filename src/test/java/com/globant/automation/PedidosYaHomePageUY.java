package pedidosYa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.globant.automation.SeleniumUtils;

public class PedidosYaHomePageUY {
//name "adress"
//name "optional"
// id search
	private WebDriver driver;
	public PedidosYaHomePageUY(WebDriver driver) {
		this.driver = driver;
		SeleniumUtils.waitUntilPresent(By.name("adress"), driver);
		PageFactory.initElements(driver, this);
	}
	@FindBy(how = How.NAME, using = "adress")
	private WebElement adressTxt;
	
	@FindBy(how = How.NAME, using = "optional")
	private WebElement foodTxt;
	
	@FindBy(how = How.ID, using = "search")
	private WebElement buttonSearch;
}

