package PedidosYa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.globant.automation.SeleniumUtils;

public class PedidosYaPopUpPage {
	private WebDriver driver;
	
	public PedidosYaPopUpPage(WebDriver driver){
		this.driver = driver;
		
		if (!SeleniumUtils.isPresent(By.id("fbLogin"), driver)) {
			throw new IllegalStateException("Page did not load");
		}
		PageFactory.initElements(driver, this);
		
		driver.switchTo().frame(iframe);
	}

	@FindBy(xpath="//div/iframe")
	private WebElement iframe;
	
	//busco las cosas normalmente, deberìa de funcionar
	
}