package pedidosYA;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.globant.automation.SeleniumUtils;

public class PedidosYaHomePage {
	private WebDriver driver;

	// //*[@id="linkUy"]/i

	public PedidosYaHomePage(WebDriver driver) {
		this.driver = driver;
		SeleniumUtils.waitUntilPresent(By.id("linkUy"), driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.ID, using = "linkUy")
	private WebElement uruguayButton;

	
	public void enter (WebDriver driver){
		uruguayButton.click();
	}
}