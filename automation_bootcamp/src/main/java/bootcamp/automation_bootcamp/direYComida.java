package bootcamp.automation_bootcamp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class direYComida {
	
	WebDriver driver;
	
	public direYComida(WebDriver driver) {
		this.driver = driver;
		if(!SeleniumUtils.isPresent(By.id("linkUy"), driver)) {
			throw new IllegalStateException("Page did not load.");
		}
		PageFactory.initElements(driver, this);		
	}

	
	//metodos
}
