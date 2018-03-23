package TestPedidosYa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import com.globant.automation.SeleniumUtils;

public class SugerenciasPage extends PageObject {
	
	@FindBy(how = How.XPATH, using = "//*[contains(text(),'Milanesa completa')]")
	private WebElement sugerencia;
	
	public SugerenciasPage (WebDriver driver) {
	    super(driver);
	}
	
	public RestaurantePage click(){
		WebElement sugerencia = SeleniumUtils.waitUntilClickable(By.xpath("//*[contains(text(),'Milanesa completa')]"), driver);
		sugerencia.click();
		return new RestaurantePage(driver);
	}

}
