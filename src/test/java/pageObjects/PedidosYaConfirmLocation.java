package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.globant.automation.SeleniumUtils;

public class PedidosYaConfirmLocation {
	protected WebDriver driver;
	
	PedidosYaConfirmLocation(WebDriver driver){
		this.driver = driver;
		SeleniumUtils.waitUntilClickable(By.cssSelector("a#confirm"), driver);
		PageFactory.initElements(driver, this);
		
	}

}
