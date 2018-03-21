package PedidosYa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.globant.automation.SeleniumUtils;

public class PedidosYaHomePage {

	private WebDriver driver;
	
	public PedidosYaHomePage(WebDriver driver){
		this.driver = driver;
		
		if (!SeleniumUtils.isPresent(By.id("linkUy"), driver)) {
			throw new IllegalStateException("Page did not load");
		}
		
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(id="linkUy")
	private WebElement uruguayFlag;
	
	
	//hago que devuelva una pagina del siguiente tipo (PedidosYaSearchPage)
	public PedidosYaSearchPage enterPage() {
        this.uruguayFlag.click();
        return new PedidosYaSearchPage(driver);
    }
		
	
}
