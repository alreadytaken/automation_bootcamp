package test.PedidosYa;

import java.awt.AWTException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class PedidosYaHomePage {
	
	@FindBy(how = How.ID, using ="linkUy")
	private WebElement uruguayButton;
	
	private WebDriver driver;

	public PedidosYaHomePage(WebDriver driver){

		this.driver = driver;				
		PageFactory.initElements(driver, this);
	}
	
	public PedidosYaHomeUruguay pedidosYaUruguay() throws AWTException {
		
		uruguayButton.click();
		return new PedidosYaHomeUruguay(driver);
	}
}