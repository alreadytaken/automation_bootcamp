package test.pedidos.ya;

import java.awt.AWTException;
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
	
	public PedidosYaHomeUruguay pedidosYaUruguay() throws AWTException {
		
		uruguayButton.click();
		return new PedidosYaHomeUruguay(driver);
	}
}

/*
Point coordenadas = uruguayButton.getLocation();
Robot mouse = new Robot();
//Actions actions = new Actions(driver);
//actions.moveToElement(uruguayButton).build().perform();
mouse.mouseMove(coordenadas.getX(), coordenadas.getY() + 120);
mouse.mousePress(InputEvent.BUTTON1_MASK);
mouse.mouseRelease(InputEvent.BUTTON1_MASK);
*/