package test.pedidos.ya;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;



public class PedidosYaHomePage {

	
	@FindBy(how = How.XPATH, using ="//a[@id='linkUy']")
	private WebElement uruguayButton;
	
	private WebDriver driver;

	public PedidosYaHomePage(WebDriver driver){

		this.driver = driver;				
		PageFactory.initElements(driver, this);

	}
	
	public PedidosYaHomeUruguay pedidosYaUruguay() {
		uruguayButton.click();
		return new PedidosYaHomeUruguay(driver);
	}
	
	
}
