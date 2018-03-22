package test.PedidosYa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.globant.automation.SeleniumUtils;

public class ChequearUserNamePage {
	
	@FindBy(how = How.ID, using = "lnkUserName")
	private WebElement userLoggedName;
	
	private WebDriver driver;
	
	public ChequearUserNamePage(WebDriver driver){

		this.driver = driver;				
		PageFactory.initElements(driver, this);
		SeleniumUtils.waitUntilClickable(userLoggedName, driver);

	}
	
	public String getNombre() {
		userLoggedName = driver.findElement(By.xpath("//div[@class='left top-link']"));
		return userLoggedName.getText();
	}

}
