package test.PedidosYa;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import com.globant.automation.SeleniumUtils;

public class SugerenciasPedidosYa {
	
	@FindBy(how = How.XPATH, using = "//div[@class='content_info']")	
	private List<WebElement> suggestion;
	
	@FindBy(how = How.XPATH, using = "//span[@class='after_price']")
	private List<WebElement> price;
	
	private WebDriver driver;
	
	public SugerenciasPedidosYa(WebDriver driver){

		this.driver = driver;				
		PageFactory.initElements(driver, this);
		SeleniumUtils.waitUntilClickable(suggestion.get(0), driver);
	}
	
	public String getPrice() {

		return price.get(0).getText();
	}
	
	public DescripcionDeSugerencia seleccionarSugerencia() {
		
		this.suggestion.get(0).click();
		return new DescripcionDeSugerencia(driver);
	}
}

