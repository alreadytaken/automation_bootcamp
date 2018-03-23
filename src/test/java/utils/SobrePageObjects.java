package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SobrePageObjects {
	
	//ATRIBUTOS MEDIANTE FindBy
	@FindBy(how = How.ID, using = "address")
	private WebElement addressButton;
	
	private WebDriver driver;

	public SobrePageObjects(WebDriver driver){

		this.driver = driver;
		PageFactory.initElements(driver, this);
		/*
			REALIZAR ESPERAS MEDIANTE XPATH
			
		WebDriverWait wait = new WebDriverWait(driver, 60); 
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class ='location-icon-map']")));
		 */

	}

}
