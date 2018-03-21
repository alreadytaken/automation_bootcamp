package TestPedidosYa;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePageUruguay extends PageObject {
	
	@FindBy(how = How.ID, using = "//input[@id='address']")
	private WebElement SearchBar;
	
	@FindBy(how = How.XPATH, using = "//input[@name='optional']")
	private WebElement ComidaSearchBar;
	
	@FindBy(how = How.ID, using = "search]")
	private WebElement SearchButton;
	
	public HomePageUruguay (WebDriver driver) {
	    super(driver);
	}
			
	

}
