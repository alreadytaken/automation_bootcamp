package PedidosYa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.globant.automation.SeleniumUtils;

public class PedidosYaSearchPage {
	private WebDriver driver;
	
	public PedidosYaSearchPage(WebDriver driver){
		this.driver = driver;
		
		if (!SeleniumUtils.isPresent(By.id("search"), driver)) {
			throw new IllegalStateException("Page did not load");
		}
		
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(name="address")
	private WebElement address;
	
	@FindBy(name="optional")
	private WebElement food;
	
	
	
	
	
}
